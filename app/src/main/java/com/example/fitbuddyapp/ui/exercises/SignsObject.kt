package com.example.fitbuddyapp.ui.exercises

import com.example.fitbuddyapp.R

object SignsObject {
    public var signsList= mutableListOf<Exercises>()

    init {
        signsList.add(Exercises("Genoflexiuni","20 de repetari", R.drawable.woman,"aaa"))
        signsList.add(Exercises("Flotari","10 repetari", R.drawable.woman,"aaa"))
        signsList.add(Exercises("Sarituri","10 repetari", R.drawable.woman,"aaa"))
        signsList.add(Exercises("Ridicari","12 repetari", R.drawable.woman,"aaa"))
    }

    fun getTitles():List<String>{
        val title= mutableListOf<String>()
        for (signs in signsList) {
            title.add(signs.title)
        }
        return title
    }

    fun getPredictions():List<String>{
        val prediction= mutableListOf<String>()
        for(sign in signsList){
            prediction.add(sign.prediction)
        }
        return prediction
    }

    fun getTitle(position:Int): String {
       return signsList[position].title
    }

    fun getDetail(position:Int): String {
        return signsList[position].detail
    }

    fun getImage(position: Int):Int{
        return signsList[position].image
    }

    fun getPrediction(position: Int):String{
        return signsList[position].prediction
    }

    fun getDetails():List<String>{
        val details= mutableListOf<String>()
        for(signs in signsList){
            details.add(signs.detail)
        }
        return details
    }

    fun getImages():List<Int>{
        val images= mutableListOf<Int>()
        for(signs in signsList){
            images.add(signs.image)
        }
        return images
    }

    fun getSign(index:Int): Exercises{
        return signsList[index]
    }
     fun getSignSize():Int
    {
         return signsList.size-1
     }

    fun setPrediction(index:Int, prediction:String){
        signsList[index].prediction=prediction
    }
}

