# Purpose
This is sample code associated with [DePaul SE452](http://www.cdm.depaul.edu/academics/pages/courseinfo.aspx?Subject=SE&CatalogNbr=452) project sample using airline reservation as problem domain.
<br>
* Milestone 1: Define the project and base structure and areas where each members will be working on
<br>
* Milestone 2: Added base Entity 
<br>
* Milestone 3: Added Services and some relationships.  Ran into a LOT of issues due to circular dependencies.
<br>
* Milestone 4: Added Redis NoSQL for Airport and refactored Flight
<br>


## Project Members

| Member | Area  | Saying |
| ----------- | ----------- | --- |
| Charlie | Flight | <i>D is for Diploma</i>
| Pat | Passenger  | <b>Carpe Diem</b>

<br/>

## Conflict Resolution
Winner of bast of 2 out of 3 winner of virtual Rock paper scissor decision

<br/>

## Communication Mechanism
Will meet using Slack and Github.   Will meet once a week after class.

<br/>

## Decision Made
| # | Area  | Decision | Alternative | Rationale
| ----------- | ----------- | --- | --- |--- |
| 1 | IDE | Use VS Code |IntelliJ, Eclipse | Language independent editor so that it can be used in non java course
| 2 | Dependency Management  | Grandle | Maven | Not a fan of XML bloat
| 3 | Code  | Lombok | Code template code | We have done too many template code and so don't need to learn that
| 4 | Configuration Management  | Yaml | Properties | Easier to view groups of configuration and it is different than what we learned in other classes with property files and so using this opporutnity to learn something different

## Lessons Learned
| # | Area | Leasson Learned 
| -- | --- | --- |
| 1 | Updating objects | Need to rerun JUnit test on builds
| 2 | Relationship | Watch out for circular relationships, be sure to add ToString.Exclude for Lombok and JsonIdentityInfo for Json building

