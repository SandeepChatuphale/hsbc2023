import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Foods from './Foods';
import HeaderComponent from './HeaderComponent';
import FooterComponent from './FooterComponent';
import AddFoodComponent from './AddFoodComponent';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <HeaderComponent></HeaderComponent>
    <AddFoodComponent></AddFoodComponent>
    <Foods></Foods>
    <FooterComponent></FooterComponent>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
