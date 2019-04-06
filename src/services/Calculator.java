package services;

public class Calculator {

    public static int getResult(String op_type, String op1, String op2){
        int op1_ = Integer.parseInt(op1,2);
        int op2_ = Integer.parseInt(op2,2);
        int res = -1;

        switch (op_type){
            case ("sum"):
                res = op1_ + op2_;
                break;
            case ("sub"):
                res = op1_ - op2_;
                break;
            case ("mpy"):
                res = op1_ * op2_;
                break;
            case ("div"):
                res = op1_ / op2_;
                break;
        }

        return res;
    }
}
