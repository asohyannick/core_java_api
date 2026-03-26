package org.asohyannick;

public class Manager extends  Employee {
  String reportingTeam;
  
  public Manager(String name, String team) {
	  super(name, team);
	  this.reportingTeam = team;
  }
}
