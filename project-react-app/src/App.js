import React from 'react';
import './App.css';
import Dashboard from './component/Dashboard';
import Header from './component/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddActivity from "./component/Activity/AddActivity"

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Route exact path="/dashboard" component={Dashboard} />
        <Route exact path="/addActivity" component={AddActivity} />
      </div>
    </Router>
  );
}

export default App;
