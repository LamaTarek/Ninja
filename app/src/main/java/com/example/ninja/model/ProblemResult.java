package com.example.ninja.model;

import android.speech.SpeechRecognizer;

import com.example.ninja.CodeforcesService.Contest;

import java.util.List;

public class ProblemResult {
   List<Problem>problemList=null;
   List<ProblemStatistics>problemStatisticsList=null;

   public ProblemResult(List<Problem> problemList, List<ProblemStatistics> problemStatisticsList) {
      this.problemList = problemList;
      this.problemStatisticsList = problemStatisticsList;
   }

   public List<Problem> getProblemList() {
      return problemList;
   }

   public void setProblemList(List<Problem> problemList) {
      this.problemList = problemList;
   }

   public List<ProblemStatistics> getProblemStatisticsList() {
      return problemStatisticsList;
   }

   public void setProblemStatisticsList(List<ProblemStatistics> problemStatisticsList) {
      this.problemStatisticsList = problemStatisticsList;
   }
}
