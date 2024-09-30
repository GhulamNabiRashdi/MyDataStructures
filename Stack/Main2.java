public class Main2 {
    public static void main(String[]args){
        
        System.out.println("Hello World!");
        LabTask task = new LabTask();
        String brackets = "(123[345])";
        
        System.out.println(task.isBalancedBracket(brackets));
    }
}
