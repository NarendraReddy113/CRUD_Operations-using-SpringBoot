import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Footer from './components/Footer/Footer';
import Header from './components/Header/Header';
import ListEmployee from './components/ListEmployee/ListEmployee';
import Employee from './components/Employee/Employee';

function App() {
  return (
    <div>
    <BrowserRouter>
    <Header />
    <div className= "container">
      <Routes>
          <Route path = "/" element = { <ListEmployee /> }></Route>
          <Route path = "/employees" element = { <ListEmployee /> }></Route>
          <Route path = "/add-employee" element = { <Employee />} ></Route>
              <Route path = "/edit-employee/:id" element = { <Employee />}></Route>
        </Routes>
    </div>
    <Footer />
    </BrowserRouter>
   </div>
  );
}

export default App;