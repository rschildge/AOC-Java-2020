class TicketField{
  int minA;
  int maxA;
  int minB;
  int maxB;
  String name;
  public TicketField(int minA, int maxA, int minB, int maxB, String name){
    this.minA= minA;
    this.maxA= maxA;
    this.minB= minB;
    this.maxB= maxB;
    this.name = name;
  }

  public boolean isValid(int num){
    if ((num >= minA && num<= maxA) || (num >= minB && num<= maxB) )
    return true;
    //System.out.println(num+" is not "+minA+"-"+maxA+" or "+minB+"-"+maxB);
    return false;
  }
  public void print(){
    System.out.println(name);
  }
}