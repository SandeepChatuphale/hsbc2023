import React, { useState } from "react";
import FoodItem from "../model/FoodItem";

const AddFoodComponent = () => {

    const [selectedFood,setSelectedFood] = useState(new FoodItem());
    const [valid,setValid] = useState(true);

    function acceptId(ev)
    {
        selectedFood.id = ev.target.value;
        if(selectedFood.id > 0)
            setValid(false);
    }
    
    function acceptItem(ev)
    {
        selectedFood.item = ev.target.value;
    }

    function acceptPrice(ev)
    {
        selectedFood.price = ev.target.price;
    }

    //This function is responsible for handling form submission
    function saveFood(ev)
    {
        ev.preventDefault();//it is called to prevent Default event occured
        console.log(selectedFood);
    }

    return(
        <React.Fragment>
            <form onSubmit={saveFood}>
                <input type="text" placeholder="Id" onBlur={acceptId}/><br/>
                <input type="text" placeholder="Item" onBlur={acceptItem}/><br/>
                <input type="text" placeholder="Price" onBlur={acceptPrice}/><br/>
                <input type="submit" value="Add" disabled={valid}/>
            </form>

        </React.Fragment>
    )
}

export default AddFoodComponent;