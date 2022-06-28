package com.example.fitbuddyapp.ui.exercises

import com.example.fitbuddyapp.R

object ExerciseObject {
    public var exercisesList= mutableListOf<Exercises>()

    init {
        exercisesList.add(Exercises("Genoflexiuni","20 de repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Flotari","10 repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Sarituri","10 repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Ridicari","12 repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Ridicari","12 repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Genoflexiuni","20 de repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Sarituri","10 repetari", R.drawable.woman,"aaa"))
        exercisesList.add(Exercises("Flotari","10 repetari", R.drawable.woman,"aaa"))

    }

    fun getTitles():List<String>{
        val title= mutableListOf<String>()
        for (signs in exercisesList) {
            title.add(signs.title)
        }
        return title
    }

    fun getPredictions():List<String>{
        val prediction= mutableListOf<String>()
        for(sign in exercisesList){
            prediction.add(sign.prediction)
        }
        return prediction
    }

    fun getTitle(position:Int): String {
       return exercisesList[position].title
    }

    fun getDetail(position:Int): String {
        return exercisesList[position].detail
    }

    fun getImage(position: Int):Int{
        return exercisesList[position].image
    }

    fun getPrediction(position: Int):String{
        return exercisesList[position].prediction
    }

    fun getDetails():List<String>{
        val details= mutableListOf<String>()
        for(signs in exercisesList){
            details.add(signs.detail)
        }
        return details
    }

    fun getImages():List<Int>{
        val images= mutableListOf<Int>()
        for(signs in exercisesList){
            images.add(signs.image)
        }
        return images
    }

    fun getSign(index:Int): Exercises{
        return exercisesList[index]
    }
     fun getSignSize():Int
    {
         return exercisesList.size-1
     }

    fun setPrediction(index:Int, prediction:String){
        exercisesList[index].prediction=prediction
    }
}

