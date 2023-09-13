import React from "react";
import FoodItem from '../model/FoodItem';
function FoodItemsComponent() 
{
  const f1 = new FoodItem(1,"Idli",10);
  const f2 = new FoodItem(2,"Wada",20);
  const foods = [];
  //const foods = [f1,f2];

  if(foods.length > 0){
  return (
      <table>
        <thead>
        <tr>
          <th>Id</th>
          <th>Item</th>
          <th>Price</th>
        </tr>
        </thead>
        {
         foods.map((food) => 
          <tbody key={food.id}>
          <tr>
           <td>{food.id}</td>
           <td>{food.item}</td>
           <td>{food.price}</td>
           </tr>
           </tbody>
         )
        }
      </table>
  );
  }
}

export default FoodItemsComponent;