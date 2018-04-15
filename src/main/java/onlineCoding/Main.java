package onlineCoding;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] lines = line.split(";");
        if (lines.length<3) {
            System.out.print("incorrect data");
            return;
        }
        LinkedList<Hik> hiks = new LinkedList<>();
        for(String temp : lines){
            Hik hik = new Hik();
            String[] temps = temp.split(",");
            hik.setDepartID(Integer.valueOf(temps[0].trim()));
            hik.setDepartName(temps[1]);
            hik.setUpDepartID(Integer.valueOf(temps[2]));
            hiks.add(hik);
        }

        Hik h = hiks.get(0);
        if (h.getDepartID()!=1 || h.getUpDepartID()!=0) {
            System.out.print("incorrect data");
            return;
        }

        // 1,A,0;
        // 2,B,1;
        // 3,C,1
        StringBuilder output = new StringBuilder();
        StringBuilder t = new StringBuilder();
        hiks.forEach(h1 ->{
            t.delete(0,t.length());
            hiks.forEach(h2 ->{
                if (h1.getUpDepartID() == h2.getDepartID()
                        && !h1.getDepartName().equals(h2.getDepartName())
                        && output.length()==0)
                    t.append(h2.getDepartName())
                            .append("-")
                            .append(h1.getDepartName());
                else {

                }
            });
            if (t.length()>0) output.append(t).append(";");
        });
        if (output.length()>0) {
            output.deleteCharAt(output.length() - 1);
            System.out.print(output.toString());
        }
        else System.out.print("incorrect data");
    }



    static class Hik{
        private int departID;
        private String departName;
        private int upDepartID;
        private boolean flag = false;

        Hik() {
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        int getDepartID() {
            return departID;
        }

         void setDepartID(int departID) {
            this.departID = departID;
        }

         String getDepartName() {
            return departName;
        }

         void setDepartName(String departName) {
            this.departName = departName;
        }

         int getUpDepartID() {
            return upDepartID;
        }

         void setUpDepartID(int upDepartID) {
            this.upDepartID = upDepartID;
        }
    }

}
