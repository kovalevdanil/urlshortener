import React from 'react'
import './App.css';
import Header from "./components/Header/Header";
import Home from "./pages/Home/Home";
import {ToastProvider} from "react-toast-notifications";

function App() {
  return (
    <div className="App">
        <Header />
        <ToastProvider>
            <Home />
        </ToastProvider>
    </div>
  );
}

export default App;
