package Exercise5_Object_Method;

public class Position {
	int positionID;
	PositionName positionName;
	
@Override
public String toString(){
	String result ="";
	result += "PositionID :"+ positionID+"\n";
	result += "PositionName :"+ positionName+"\n";
	return result;
}
}
