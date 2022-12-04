package com.pluralsight.courseinfo.cli;

import java.util.Scanner;

public class CourseRetriever {

    public static void main(String... args) {
        System.out.println("Course Retriever started");

        if(args.length == 0 ) {
            System.out.println("Please provide an author name as first arguement.");
            return;
        }

        try {
            retrieveCourses(args[0]);
        } catch(Exception e) {
            System.out.println("Unexpected error");
            e.printStackTrace();
        }
    }

    private static void retrieveCourses(String authorId) {
//        Scanner input = new Scanner(System.in);
//        String newAuthor = input.next();
        System.out.println("Retrieving courses for author " + authorId);
    }

}