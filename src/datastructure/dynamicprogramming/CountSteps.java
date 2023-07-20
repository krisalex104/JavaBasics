package datastructure.dynamicprogramming;

public class CountSteps {

    public static int countMinStepsToOne(int n) {
        //Your code goes here
        if(n==1){
            return 0;
        }
        int opt1=countMinStepsToOne(n-1);
        int minSteps=opt1;

        if(n%3==0){
            int opt2=countMinStepsToOne(n/3);
            if(opt2<opt1){
                minSteps=opt2;
            }
        }
        if(n%2==0){
            int opt3=countMinStepsToOne(n/2);
            if(opt3<minSteps){
                minSteps=opt3;
            }
        }

        return 1+minSteps;
    }

    public static int countToMinStepsM(int n){
        int []storage=new int[n+1];
        return countToMinStepsM(n,storage);
    }

    public static int countToMinStepsM(int n,int []storage){
        if(n==1){
            storage[n]=0;
            return storage[n];
        }
        int opt1=countToMinStepsM(n-1,storage);
        int minSteps=opt1;

        if(n%3==0){
            int opt2=countToMinStepsM(n/3,storage);
            if(opt2<minSteps){
                minSteps=opt2;
            }
        }
        if(n%2==0){
            int opt3=countToMinStepsM(n/2,storage);
            if(opt3<minSteps){
                minSteps=opt3;
            }
        }

        storage[n]= 1+minSteps;
        return storage[n];
    }

    public static int countToMinStepsDp(int n){
        int []storage=new int[n+1];
        storage[1]=0;
        for(int i=2;i<=n;i++){
            int minSteps=storage[i-1];
            if(i%3==0){
                if(minSteps>storage[i/3]){
                    minSteps=storage[i/3];
                }
            }

            if(i%2==0){
                if(minSteps>storage[i/2]){
                    minSteps=storage[i/2];
                }
            }
            storage[i]=1+minSteps;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n=100;
        System.out.println(countMinStepsToOne(n));
        System.out.println(countToMinStepsM(n));
        System.out.println(countToMinStepsDp(n));
    }
}
