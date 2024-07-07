import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './components/include/Header';
import { Suspense } from 'react';
import { ThemeProvider } from './components/context/themeProvider';
import { GlobalStyle } from './components/theme/GlobalStyle';
import Main from './components/page/Main';
import Sub from './components/page/Sub';

function App() {
  return (
    <BrowserRouter>
      <ThemeProvider>
        <GlobalStyle/>
          <Suspense fallback={<div> ...loading </div>}>
          <Header />
            <Routes>
              <Route exact path = "/" component={Main}/>
              <Route exact path = "/sub" component={Sub}/>    
            </Routes>
            </Suspense>
      </ThemeProvider>
    </BrowserRouter>
  );
}

export default App;
