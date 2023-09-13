

/*
function GreetingComponent()
{
    return (<h1>Hello From GreetingComponent</h1>)
}
*/

//Approach 1 - we are accepting all properties in one single 
              //property
const GreetingComponent = (props) => {
    const name = 'HSBC'; //this is variable

    //props.company = 'Changed'; properties are READ ONLY
    return (
        <div>
            <h1>Hello {props.company}  From GreetingComponent</h1>
            <p>Location is {props.location}</p>
        </div>
    )
}
/*
const GreetingComponent = ({company,location}) => {
    const name = 'HSBC'; //this is variable

    return (
        <div>
            <h1>Hello {company}  From GreetingComponent</h1>
            <p>Location is {location}</p>
        </div>
    )
}
*/
export default GreetingComponent;