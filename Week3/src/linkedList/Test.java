package linkedList;

import mergesort.MergeSort;

public class Test {

    static class Employee implements Comparable<Employee>{
        int salary;
        String name;

        public Employee(){}

        public Employee(String name, int salary){
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee o) {
            return this.salary - o.salary;
        }
    }

    public static void main(String[] args) {
        Employee[] emps = new Employee[2];
        emps[0] = new Employee("Gaurav", 20000);
        emps[1] = new Employee("Kajal", 30000);
        Integer[] ints = new Integer[]{1,8,3,6,9,12,11,10};
//        Integer[] aux = new Integer[11];
        MergeSort.sort(ints);
        for(int i = 0 ;i < ints.length; i++){
            System.out.println(ints[i]);
        }

    }
}
