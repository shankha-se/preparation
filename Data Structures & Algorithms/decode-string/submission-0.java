class Solution {
    public String decodeString(String s) {
        Stack<String> main = new Stack<>();
        Stack<Integer> number = new Stack<>();
        int currentNum = 0;

        for(char ch : s.toCharArray()){
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }
            else if(ch == '['){
                number.push(currentNum);
                currentNum = 0;
                main.push("[");
            }
            else if (ch == ']') {
                String tempResult = "";
                while(!main.peek().equals("[")){
                    tempResult = main.pop() + tempResult;
                }
                main.pop();
                int counter = number.pop();
                StringBuilder repeated = new StringBuilder();
                for(int i = 1; i <= counter; i++){
                    repeated.append(tempResult);
                }
                main.push(repeated.toString());
            }
            else {
                main.push(String.valueOf(ch));
            }
        }
        StringBuilder result = new StringBuilder();
        for(String str : main){
            result.append(str);
        }
        return result.toString();
    }

}