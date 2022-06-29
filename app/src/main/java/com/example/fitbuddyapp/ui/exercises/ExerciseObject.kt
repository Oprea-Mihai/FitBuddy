package com.example.fitbuddyapp.ui.exercises

import com.example.fitbuddyapp.R

object ExerciseObject {
    public var exercisesList= mutableListOf<Exercises>()

    init {
        exercisesList.add(Exercises("Genoflexiuni","20 de repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Flotari","10 repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Sarituri cu forfecare","10 repetari", R.drawable.woman,"2"))
        exercisesList.add(Exercises("Flexii abdominale","12 repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Fandari incrucisate","12 repetari", R.drawable.woman,"2"))
        exercisesList.add(Exercises("Flotari in genunchi","20 de repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Genoflexiuni cu saritura","10 repetari", R.drawable.woman,"3"))
        exercisesList.add(Exercises("Fandari laterale","10 repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Flotare si rasucire","12 repetari", R.drawable.woman,"3"))
        exercisesList.add(Exercises("Fandari inapoi","10 repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Podul","10 repetari", R.drawable.woman,"2"))
        exercisesList.add(Exercises("Sprijinire cu spatele de perete","20 de secunde", R.drawable.woman,"2"))
        exercisesList.add(Exercises("Cercuri cu bratele","20 de repetari", R.drawable.woman,"1"))
        exercisesList.add(Exercises("Scandura","45 de secunde", R.drawable.woman,"2"))
        exercisesList.add(Exercises("Alergare cu genunchii la piept","45 de secunde", R.drawable.woman,"1"))

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
            prediction.add(sign.difficulty)
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

    fun getDifficulty(position: Int):String{
        return exercisesList[position].difficulty
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

    fun setDifficulty(index:Int, difficult:String){
        exercisesList[index].difficulty=difficult
    }
}

