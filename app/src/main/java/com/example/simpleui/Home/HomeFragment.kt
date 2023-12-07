package com.example.simpleui.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleui.AddExercise
import com.example.simpleui.AddExerciseAdapter
import com.example.simpleui.Category
import com.example.simpleui.CategoryItemAdapter
import com.example.simpleui.Exercise
import com.example.simpleui.ExerciseItemAdapter
import com.example.simpleui.GoalsItemAdapter
import com.example.simpleui.Meal
import com.example.simpleui.MealItemAdapter
import com.example.simpleui.R
import com.example.simpleui.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val list = ArrayList<Category>()
    private val listExercise = ArrayList<Exercise>()
    private val listMeal = ArrayList<Meal>()
    private val listAddExercise = ArrayList<AddExercise>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGoals.layoutManager = LayoutManager

        binding.rvCategory.setHasFixedSize(true)

        binding.rvExercise.setHasFixedSize(true)

        binding.rvMeal.setHasFixedSize(true)

        binding.rvAddExercise.setHasFixedSize(true)

        listAddExercise.addAll(getListAddExercise())
        showRecyclerAddExercise()

        listMeal.addAll(getListMeal())
        showRecyclerMeal()

        listExercise.addAll(getListExercise())
        showRecyclerExercise()


        list.addAll(getListCategory())
        showRecyclerCategory()

        setListData()

        return binding.root
    }

    private fun showRecyclerAddExercise() {
        binding.rvAddExercise.layoutManager = LinearLayoutManager(requireContext())
        val listAddExerciseAdapter = AddExerciseAdapter(listAddExercise)
        binding.rvAddExercise.adapter = listAddExerciseAdapter
    }

    private fun getListAddExercise(): Collection<AddExercise> {
        val bgPhoto = resources.obtainTypedArray(R.array.addExercise_bg)
        val photo = resources.obtainTypedArray(R.array.addExercise_photo)
        val title = resources.getStringArray(R.array.addExercise_title)
        val kalori = resources.getStringArray(R.array.addExercise_kalori)
        val time = resources.getStringArray(R.array.addExercise_time)
        val level = resources.getStringArray(R.array.addExercise_level)

        val listAddExercise = ArrayList<AddExercise>()
        for(i in title.indices){
            val addexercise = AddExercise(bgPhoto.getResourceId(i, -1),
                photo.getResourceId(i, -1),
                title[i],
                kalori[i],
                time[i],
                level[i])
            listAddExercise.add(addexercise)
        }
        return listAddExercise
    }

    private fun showRecyclerMeal() {
        binding.rvMeal.layoutManager = LinearLayoutManager(requireContext())
        val listMealAdapter = MealItemAdapter(listMeal)
        binding.rvMeal.adapter = listMealAdapter
    }

    private fun getListMeal(): Collection<Meal> {
        val photoMeal = resources.obtainTypedArray(R.array.meal_photo)
        val titleMeal = resources.getStringArray(R.array.meal_title)
        val kaloriMeal = resources.getStringArray(R.array.meal_kalori)

        val listMeals = ArrayList<Meal>()
        for(i in titleMeal.indices){
            val meal = Meal(photoMeal.getResourceId(i, -1), titleMeal[i], kaloriMeal[i])
            listMeals.add(meal)
        }
        return listMeals
    }

    private fun showRecyclerExercise() {
        binding.rvExercise.layoutManager = LinearLayoutManager(requireContext())
        val listExerciseAdapter = ExerciseItemAdapter(listExercise)
        binding.rvExercise.adapter = listExerciseAdapter
    }

    private fun getListExercise(): Collection<Exercise> {
        val imgPhoto = resources.obtainTypedArray(R.array.category_photo)
        val title = resources.getStringArray(R.array.category_title)
        val time = resources.getStringArray(R.array.category_time)

        val listExercises = ArrayList<Exercise>()
        for(i in title.indices){
            val exercise = Exercise(imgPhoto.getResourceId(i,-1), title[i], time[i])
            listExercises.add(exercise)
        }
        return listExercises
    }

    private fun showRecyclerCategory() {
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listCategoryAdapter = CategoryItemAdapter(list)
        binding.rvCategory.adapter = listCategoryAdapter
    }

    private fun getListCategory(): Collection<Category> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCategory = ArrayList<Category>()
        for(i in dataName.indices){
            val category = Category(dataName[i], dataPhoto.getResourceId(i, -1))
            listCategory.add(category)
        }

        return listCategory
    }

    private fun setListData() {
        val dataList:ArrayList<String> = ArrayList()

        dataList.add("Loose Weight")
        dataList.add("Gain Weight")
        dataList.add("Body Building")
        dataList.add("Healthy")

        val adapter = GoalsItemAdapter(dataList)
        binding.rvGoals.adapter = adapter
    }


}