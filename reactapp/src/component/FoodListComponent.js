import { useState } from "react";
import FoodItem from "../model/FoodItem";

const FoodListComponent = (props)=> {

        const [flag,setFlag] = useState(false);
    const [selectedFood,setSelectedFood] = useState(new FoodItem());

    return (
        <div>
            {flag && <input type="text" 
                     value={selectedFood.item}></input> }
        <ul>
            <li>
                    {props.food.item}  {props.food.price} 
                    <button 
                    onClick={() => {setFlag(true);
                                    setSelectedFood(props.food)}}>Show</button>
             </li> 
        </ul>
        </div>
    );
}


export default FoodListComponent;