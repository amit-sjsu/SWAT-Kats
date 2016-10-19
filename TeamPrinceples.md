This document descibes the following thing :

- What framework and models we will be using for developement.
- What tools we will be using.
- Team Rules

So starting with framework and models we will be usin XP Team Values, KanBan board to track our progress and Sprint methodologies to accomplish our goals.

XP TEAM VAlues:
All team members must have this all qualities:
1) Simplicity
2) Courage
3) Respect
4) Communication
5) Feedback

Kanban:
We will be useing http://waffle.io as kanban board to maintain tasklist and following are the kanban policies that must be followed:
- Backlog
  We would write good user stories and here is example of it.
  Template:
  In order to <<reason>>, as a <<role>>, I want <<functionality>>
  Like : In order to obtain cash conveniently, as a bank customer, I want to withdraw cash via an auto-teller Machine.
  
  For Behaviour Driven Development:
  Template:
  Given <<initial condition(s)>>
  When <<event>> occurs
  Then <<Expected outcome(s)>>

  Also for good user story it should have following attibutes:
  1)Independent
  2)Negotiable
  3)Valuable
  4)Estimable
  5)Small
  6)Testable
  
- Ready
  Once a Member has been looking or started to take up backlog task goes into ready state. To get backlog into ready state, team member shouldnt have anything in inprogress, testing or review mode.

- Inprogress
  Where you actually do work
- Testing 
  Test you work/code using unit testing
- Review
  Here we using extreme programming rule where we have a peer, who does code review for the team. Two member of the team has to do a code review.
- Done
  It should have clear defination of done, and member can move its backlog to done when target is achieved.

Also the task in done phase can get back to inprogess, if we find that it was not completed before.


So we limit are WIP limit to 4 which means that we dont have more than 4 tasks
across Inprogress, Testing and Review part. So to finish backlog we must complete the current task rather then taking new one. 