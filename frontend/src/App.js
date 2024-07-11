import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './components/include/Header';
import HomePage from './components/page/HomePage';

function App() {
  return (
    <>
    <Routes>
      <Route path='/' element={<HomePage />} />  

      <Route path='/free' element={<freeBoard />} />  
      <Route path='/humor' element={<humorBoard />} />  
      <Route path='/market' element={<marketBoard />} />  
      

    </Routes>
    </>
  );
}

export default App;
