package com.pluralsight.courseinfo.cli;

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
        System.out.println("Retrieving courses for author" + authorId);
    }

}