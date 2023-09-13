import React from "react";
import FoodItem from "../model/FoodItem";
import FoodListComponent from './FoodListComponent'
import { useState } from "react";

function Foods() 
{  
  const f1 = new FoodItem(1,"Idli",10);
  const f2 = new FoodItem(2,"Wada",20);
  const foods = [f1,f2];
  const [flag,setFlag] = useState(false);

  //this is traditional approach
  function save()
  {
    alert('Data Saved')
  }

  return (
    <div>
      
      { flag && foods.map(food => <FoodListComponent key={food.id}
                          food={food}></FoodListComponent>) }

      {/*
      Instead of Writing  FoodListComponent again and again
      manually we are using map to iterate 
      <FoodListComponent food={foods[0]}></FoodListComponent>
      <FoodListComponent food={foods[1]}></FoodListComponent>
      */}  
      {/* Event handling - button event with save function    */}
      <button onClick={save}>Save</button>

      {/* Event handling using arrow function function   */}    
      <button onClick={ ()=> setFlag(true) }>Show All</button>
    </div>
   );
  }
export default Foods;




