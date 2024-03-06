
import java.util.*;
import java.util.stream.Collectors;


public class countdown1 {
    public static void solve(ArrayList<Integer> nums, int target, HashSet<String> ans, char[] operator, List<String> ExpressionMap){
        int n = nums.size();
        for(int i = 0; i < n; i ++){
            for(int j = i+1; j < n; j ++){
                for(int k = 0; k < 4; k ++){

                    char op = operator[k];
                    int res = 0;
                    String exp = "";
                    String num1 = ExpressionMap.get(i);
                    String num2 = ExpressionMap.get(j);
                    boolean flag = false;
                    if(op == '+'){
                        res = nums.get(i) + nums.get(j);
                        exp = "(" + num1 + "+" + num2 + ")";
                    }
                    else if(op == '-'){
                        res = nums.get(i) - nums.get(j);
                        if(res == 0) flag = true;
                        if(res < 0) {
                            res = -res;
                            exp = "(" + num2 + "-" + num1 + ")";
                        }
                        if(res > 0) exp = "(" + num1 + "-" + num2 + ")";
                    }
                    else if(op == '*'){
                        res = nums.get(i) * nums.get(j);
                        exp = "(" + num1 + "*" + num2 + ")";
                    }
                    else{
                        if(nums.get(i) % nums.get(j) != 0) flag = true;
                        res = nums.get(i) / nums.get(j);
                        exp = "(" + num1 + "/" + num2 + ")";
                    }
                    if(flag) continue;

                    if(res == target) {
                        ans.add(exp);
                    }

                    ArrayList<Integer> temp = new ArrayList<>();
                    ArrayList<String> Exptemp = new ArrayList<>();

                    nums.stream().forEach((num) -> temp.add(num));
                    ExpressionMap.stream().forEach((e)->Exptemp.add(e));

                    ExpressionMap.remove(i);
                    nums.remove(i);

                    ExpressionMap.remove(j-1);
                    nums.remove(j-1);

                    nums.add(res);
                    ExpressionMap.add(exp);

                    solve(nums, target, ans, operator, ExpressionMap);

                    nums = temp;
                    ExpressionMap = Exptemp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array - ");
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            int ele = sc.nextInt();
            nums.add(ele);
        }
        Collections.sort(nums);

        List<String> ExpMap = nums.stream().map(c->c.toString()).collect(Collectors.toList());

        System.out.print("Enter the target element - ");
        int target = sc.nextInt();
        HashSet<String> ans = new HashSet<>();
        char[] operator = new char[]{'+','-','*','/'};
        solve(nums, target, ans, operator, ExpMap);
        ans.forEach((s)->System.out.println(s));
    }
}
