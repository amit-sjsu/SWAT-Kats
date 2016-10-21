import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        House objHouse=new House();

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Message message = new Message("Move 0");
        addObject(message, 69,40);
        Path path=new Path();

        House house = new House();
        addObject(house,350,235);
        House house2 = new House();
        addObject(house2,579,137);
        House house3 = new House();
        addObject(house3,830,293);
        House house4 = new House();
        addObject(house4,496,392);
        House house5 = new House();
        addObject(house5,154,323);
        Player player = new Player();
        addObject(player,197,517);
        house.setLocation(243,127);
        house4.setLocation(482,527);
        house5.setLocation(152,332);
        house.setLocation(313,72);
        house2.setLocation(760,73);
        house5.setLocation(168,509);
        house.setLocation(179,249);
        house4.setLocation(286,69);
        house.setLocation(180,283);
        house2.setLocation(448,295);
        house3.setLocation(568,505);
        House house6 = new House();
        addObject(house6,845,361);
        House house7 = new House();
        addObject(house7,863,159);
        House house8 = new House();
        addObject(house8,639,56);
        House house9 = new House();
        addObject(house9,672,247);
        House house10 = new House();
        addObject(house10,458,176);
        house2.setLocation(407,370);
        house3.setLocation(605,510);
        house6.setLocation(799,383);
        house9.setLocation(650,261);
        house10.setLocation(453,176);
        house5.setLocation(78,511);
        house.setLocation(115,308);
        house4.setLocation(191,106);
        house2.setLocation(335,358);
        house3.setLocation(470,518);
        house3.setLocation(528,509);
        house6.setLocation(790,414);
        house7.setLocation(866,180);
        house9.setLocation(664,282);
        house8.setLocation(643,82);
        house4.setLocation(199,94);
        house5.setLocation(111,507);
        Path path1 = new Path();
        addObject(path1,614,511);
        Path path2 = new Path();
        addObject(path2,671,486);
        Path path3 = new Path();
        addObject(path3,719,461);
        house6.setLocation(849,400);
        Path path4 = new Path();
        addObject(path4,778,437);
        Path path5 = new Path();
        addObject(path5,778,437);
        Path path6 = new Path();
        addObject(path6,873,331);
        Path path7 = new Path();
        addObject(path7,867,289);
        house7.setLocation(861,218);
        Path path8 = new Path();
        addObject(path8,793,171);
        Path path9 = new Path();
        addObject(path9,762,145);
        Path path10 = new Path();
        addObject(path10,725,120);
        house8.setLocation(659,86);
        house9.setLocation(535,338);
        house6.setLocation(770,339);
        house6.setLocation(766,351);
        path6.setLocation(789,300);
        path7.setLocation(825,268);
        path2.setLocation(631,457);
        path3.setLocation(680,427);
        path5.setLocation(717,398);
        path4.setLocation(661,148);
        Path path11 = new Path();
        addObject(path11,719,320);
        Path path12 = new Path();
        addObject(path12,706,296);
        path12.setLocation(699,284);
        Path path13 = new Path();
        addObject(path13,682,249);
        Path path14 = new Path();
        addObject(path14,674,220);
        path4.setLocation(431,248);
        house8.setLocation(648,152);
        path14.setLocation(659,214);
        path8.setLocation(812,175);
        path9.setLocation(766,150);
        path10.setLocation(711,157);
        path9.setLocation(761,184);
        path8.setLocation(795,212);
        path4.setLocation(599,194);
        Path path15 = new Path();
        addObject(path15,580,231);
        Path path16 = new Path();
        addObject(path16,568,266);
        path16.setLocation(552,278);
        path15.setLocation(573,241);
        path4.setLocation(599,204);
        Path path17 = new Path();
        addObject(path17,525,400);
        Path path18 = new Path();
        addObject(path18,525,433);
        Path path19 = new Path();
        addObject(path19,526,468);
        house3.setLocation(532,526);
        Path path20 = new Path();
        addObject(path20,604,355);
        Path path21 = new Path();
        addObject(path21,658,368);
        Path path22 = new Path();
        addObject(path22,711,369);
        path5.setLocation(723,402);
        path20.setLocation(596,345);
        path21.setLocation(645,353);
        path22.setLocation(699,361);
        house10.setLocation(413,304);
        house4.setLocation(270,138);
        Path path23 = new Path();
        addObject(path23,355,157);
        Path path24 = new Path();
        addObject(path24,419,159);
        Path path25 = new Path();
        addObject(path25,480,166);
        Path path26 = new Path();
        addObject(path26,541,167);
        Path path27 = new Path();
        addObject(path27,589,172);
        path23.setLocation(334,146);
        path24.setLocation(392,147);
        path25.setLocation(447,145);
        path26.setLocation(501,146);
        path27.setLocation(557,146);
        house8.setLocation(636,149);
        house10.setLocation(412,260);
        house10.setLocation(404,251);
        Path path28 = new Path();
        addObject(path28,578,187);
        Path path29 = new Path();
        addObject(path29,543,206);
        Path path30 = new Path();
        addObject(path30,504,235);
        path30.setLocation(480,236);
        path29.setLocation(521,206);
        path28.setLocation(565,180);
        Path path31 = new Path();
        addObject(path31,289,190);
        Path path32 = new Path();
        addObject(path32,324,214);
        path32.setLocation(330,227);
        path31.setLocation(295,195);
        house.setLocation(229,334);
        house2.setLocation(382,535);
        house.setLocation(176,344);
        Path path33 = new Path();
        addObject(path33,221,192);
        Path path34 = new Path();
        addObject(path34,214,223);
        Path path35 = new Path();
        addObject(path35,199,259);
        Path path36 = new Path();
        addObject(path36,193,291);
        path33.setLocation(221,189);
        path34.setLocation(203,223);
        house.setLocation(174,352);
        path36.setLocation(177,295);
        house5.setLocation(161,514);
        Path path37 = new Path();
        addObject(path37,175,410);
        Path path38 = new Path();
        addObject(path38,174,459);
        path37.setLocation(163,416);
        path38.setLocation(168,450);
        house5.setLocation(176,509);
        house2.setLocation(343,411);
        player.setLocation(207,521);
        house5.setLocation(208,506);
        Path path39 = new Path();
        addObject(path39,273,509);
        Path path40 = new Path();
        addObject(path40,333,526);
        Path path41 = new Path();
        addObject(path41,416,530);
        Path path42 = new Path();
        addObject(path42,473,536);
        path39.setLocation(278,515);
        path40.setLocation(333,520);
        path41.setLocation(390,520);
        path42.setLocation(453,524);
        house2.setLocation(345,387);
        player.setLocation(73,528);
        Path path43 = new Path();
        addObject(path43,289,432);
        Path path44 = new Path();
        addObject(path44,259,468);
        Path path45 = new Path();
        addObject(path45,383,305);
        Path path46 = new Path();
        addObject(path46,382,341);
        Path path47 = new Path();
        addObject(path47,402,442);
        Path path48 = new Path();
        addObject(path48,438,475);
        Path path49 = new Path();
        addObject(path49,490,500);
        path47.setLocation(395,429);
        path48.setLocation(431,463);
        path49.setLocation(478,489);
        Path path50 = new Path();
        addObject(path50,427,385);
        Path path51 = new Path();
        addObject(path51,470,364);

        message.setLocation(92,37);
        removeObject(player);
        message.setLocation(70,40);
        house4.setLocation(167,101);
        house.setLocation(131,356);
        house5.setLocation(135,527);
        path33.setLocation(162,161);
        path34.setLocation(163,202);
        path35.setLocation(160,249);
        path36.setLocation(153,290);
        path37.setLocation(157,415);
        path38.setLocation(153,456);
        path31.setLocation(242,159);
        path32.setLocation(287,193);
        Path path52 = new Path();
        addObject(path52,329,234);
        path23.setLocation(246,108);
        path24.setLocation(324,108);
        path25.setLocation(402,102);
        path26.setLocation(480,100);
        path27.setLocation(553,99);
        house8.setLocation(642,83);
        path10.setLocation(714,108);
        path9.setLocation(772,130);
        path8.setLocation(804,171);
        house7.setLocation(895,202);
        path8.setLocation(827,169);
        path7.setLocation(852,267);
        path6.setLocation(847,312);
        path7.setLocation(883,265);
        house6.setLocation(805,368);
        path2.setLocation(673,479);
        path3.setLocation(725,447);
        path5.setLocation(768,413);
        path28.setLocation(589,138);
        path29.setLocation(525,190);
        path14.setLocation(670,135);
        path13.setLocation(689,168);
        path12.setLocation(711,209);
        path11.setLocation(735,251);
        Path path53 = new Path();
        addObject(path53,756,299);
        path22.setLocation(733,371);
        path21.setLocation(665,369);
        path20.setLocation(617,330);
        removeObject(path20);
        house9.setLocation(590,341);
        path16.setLocation(592,284);
        path4.setLocation(603,210);
        path4.setLocation(626,133);
        path15.setLocation(610,233);
        path4.setLocation(625,173);
        path28.setLocation(587,128);
        path26.setLocation(485,82);
        path27.setLocation(554,68);
        path28.setLocation(586,116);
        Path path54 = new Path();
        addObject(path54,546,155);
        path54.setLocation(546,144);
        path29.setLocation(512,178);
        path30.setLocation(475,214);
        path4.setLocation(620,159);
        path15.setLocation(605,201);
        Path path55 = new Path();
        addObject(path55,594,243);
        house3.setLocation(618,541);

        path2.setLocation(732,484);
        path3.setLocation(770,449);
        path17.setLocation(568,404);
        path18.setLocation(569,445);
        path19.setLocation(578,491);
        path51.setLocation(498,371);
        path42.setLocation(543,538);
        path49.setLocation(484,512);
        path48.setLocation(436,471);
        path39.setLocation(209,508);
        path40.setLocation(181,563);
        path40.setLocation(201,562);
        path41.setLocation(267,560);
        Path path56 = new Path();
        addObject(path56,340,562);
        Path path57 = new Path();
        addObject(path57,410,561);
        Path path58 = new Path();
        addObject(path58,483,563);
        path42.setLocation(547,526);
        path19.setLocation(620,490);
        path42.setLocation(559,517);
        Path path59 = new Path();
        addObject(path59,549,565);
        path18.setLocation(608,448);
        path17.setLocation(593,404);
        path49.setLocation(503,500);
        path48.setLocation(449,478);
        path47.setLocation(406,448);
        path49.setLocation(507,500);
        path48.setLocation(460,476);
        path47.setLocation(421,447);
        Path path60 = new Path();
        addObject(path60,388,434);
        path47.setLocation(422,453);

        path19.setLocation(622,482);
        path2.setLocation(686,517);
        path3.setLocation(740,488);
        path5.setLocation(785,451);
        path5.setLocation(797,435);
        path3.setLocation(758,477);
        path2.setLocation(706,509);
        house3.setLocation(633,539);
        house3.setLocation(650,559);

        path2.setLocation(712,528);
        path3.setLocation(759,482);
        removeObject(path);
        house3.setLocation(630,561);
        path2.setLocation(698,528);
        path3.setLocation(732,499);
        Path path61 = new Path();
        addObject(path61,771,465);
        path5.setLocation(800,424);
        path61.setLocation(774,458);
        path3.setLocation(737,492);
        Submit submit = new Submit();
        addObject(submit,886,561);
    }
}
