import React from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from './component/Dashboard';
import Header from './component/Layout/Header';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Header></Header>
        <img src={logo} className="App-logo" alt="logo" />
        <Dashboard />
      </header>
    </div>
  );
}

export default App;
