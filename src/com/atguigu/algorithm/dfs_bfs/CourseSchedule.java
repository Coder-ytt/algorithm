package com.atguigu.algorithm.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseSchedule {
    //方法一：BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 定义数组保存所有节点入度
        int[] inDegrees = new int[numCourses];

        // 定义HashMap存储邻接矩阵
        HashMap<Integer, ArrayList<Integer>> followUpCourses = new HashMap<>();

        // 1. 遍历先决条件，计算入度和后续节点
        for (int[] prerequisite: prerequisites){
            inDegrees[prerequisite[0]] ++;    // 后修课程入度加1

            // 获取先修课程的后续节点列表
            ArrayList<Integer> followUpCourseList = followUpCourses.getOrDefault(prerequisite[1], new ArrayList<>());
            followUpCourseList.add(prerequisite[0]);    // 后修课程加入列表
            followUpCourses.put(prerequisite[1], followUpCourseList);
        }

        // 定义队列保存当前可以学习的课程，入度为0的课程
        LinkedList<Integer> selectableCourses = new LinkedList<>();

        // 2. 启动BFS，将入度为0的所有课程入队
        for (int i = 0; i < numCourses; i++){
            if (inDegrees[i] == 0)
                selectableCourses.offer(i);
        }

        // 用一个变量记录已学过的课程数量
        int finishedCoursesNum = 0;

        // 3. 不停地出队（学习课程），将后续课程入度减1，并将新的入度为0的课程入队
        while (!selectableCourses.isEmpty()){
            int course = selectableCourses.poll();    // 出队
            finishedCoursesNum ++;

            // 遍历当前课程的后续课程，入度减1
            for (int followUpCourse: followUpCourses.getOrDefault(course, new ArrayList<>())){
                inDegrees[followUpCourse] --;
                // 如果当前后续课程入度减成1，入队
                if (inDegrees[followUpCourse] == 0)
                    selectableCourses.offer(followUpCourse);
            }
        }

        // 4. 判断是否学完所有课程
        return finishedCoursesNum == numCourses;
    }
}
