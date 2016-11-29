
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;
import org.restlet.*;
import org.json.*;
import java.lang.String;;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;

public class LevelChangeScreen extends MSTGame
{
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");
     Message player1Name= new Message();Message player1TimeTaken= new Message();Message player1Move= new Message();
     Message player1Solution= new Message(); Message player2Waiting= new Message();
      Message player2Name= new Message();Message player2TimeTaken= new Message();Message player2Move= new Message();
      Message player2Solution= new Message();
       Replay replay = new Replay();
      private String [] part;
      private String [] Player1Details;
     private String [] Player2Details;
     private String state;
      
      
    private final String service_url = "http://localhost:8091/restlet/" ;
      
      
    public LevelChangeScreen()//int score)
    {    
        //backgroundMusic.play(); 
       
   
       
        
        prepare();
    }

    public void stopBackgroundMusic()
    {
        backgroundMusic.stop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        addObject(player1Name, 300, 480); addObject(player1TimeTaken, 300, 510);addObject(player1Move, 300, 540);
        addObject(player1Solution,300, 580);  addObject(player2Waiting,700, 480);
        addObject(player2Name, 700, 480); addObject(player2TimeTaken, 700, 510);addObject(player2Move, 700, 540);
        addObject(player2Solution ,700,580);
        smily smily = new smily();
        addObject(smily,513,314);
        smily.setLocation(496,309);
       
       
    }
    
    public void act()
    {   try
        {
                    ClientResource helloClientresource = new ClientResource( service_url+"getGameState" );
                    Representation response = helloClientresource.get();
                    JSONObject jsonobject= new JSONObject(response.getText());
                  //  JSONObject obj= new JSONObject();
                     this.state=jsonobject.getString("currentGameState");  
                  
                  
                   if(jsonobject.getString("currentGameState").equals("PlayerOneSubmiitedState"))
                   {
                       try{
                            System.out.println("Inside Try");  
                           
                            helloClientresource = new ClientResource( service_url+"getScores" );
                            response = helloClientresource.get();
                            jsonobject= new JSONObject(response.getText());
                            System.out.println(jsonobject.getString("Scores"));
                            System.out.println(jsonobject.getString("Decision"));
                            
                            displayScorePlayer1(jsonobject.getString("Scores"),jsonobject.getString("Decision"));
                            
                        }
                        catch(Exception e){}
                    }
                      
                    
                     else if(jsonobject.getString("currentGameState").equals("Game Finished State"))
                     {
                       
                        try{
                            helloClientresource = new ClientResource( service_url+"getScores" );
                            response = helloClientresource.get() ;
                            jsonobject= new JSONObject(response.getText());
                            System.out.println(jsonobject.getString("Scores"));
                            System.out.println(jsonobject.getString("Decision"));
                            displayScorePlayer1(jsonobject.getString("Scores"),jsonobject.getString("Decision"));
                            displayScorePlayer2(jsonobject.getString("Scores"),jsonobject.getString("Decision"));
                           
                             addObject(replay, 496, 700);
                          }
                        catch(Exception e){}
                      }
                    
                
                 }
                    catch ( Exception e ) {
                // setMessage( e.getMessage() ) ;
            }  
        
        }
            public void displayScorePlayer1(String score, String decision)
            {
                String [] part; String pa;
                part=score.split("-");
                
                System.out.println(part[0]);
                
                
                Player1Details=part[0].split(":");
                
                
                
                int timeleft = 30-Integer.parseInt(Player1Details[2]);            
                player1Name.setMessage("Player :  " +Player1Details[0]);
                            player1TimeTaken.setMessage("Time Taken :  "+ String.valueOf(timeleft));
                            player1Solution.setMessage("Winner Is : " + decision);
                            if(this.state.equals("PlayerOneSubmiitedState"))
                            {
                              player2Waiting.setMessage ("Waiting for Player 2 to submit");
                            }
                            if(this.state.equals("Game Finished State"))
                            {
                              player2Waiting.setMessage (" ");
                            }
                
            }
            
            public void displayScorePlayer2(String score,String decision)
            {  
                            part=score.split("-");
                            Player2Details=part[1].split(":");
                            int timeleft = 30-Integer.parseInt(Player2Details[2]);
                            player2Name.setMessage("Player :  " +Player2Details[0]);
                            player2TimeTaken.setMessage("Time Taken :  "+ String.valueOf(timeleft));
                          
                            player2Solution.setMessage("Winner Is : " + decision);
                            
                            
                            
            }
                
            
        
       
    }
    
