
import { ThemeProvider } from '@mui/material';
import './App.css';

import darkTheme from './theme/darktheme';
import Navbar from './Page/Navbar/Navbar';



function App() {
  return (
    <ThemeProvider theme={darkTheme}>
     <Navbar/>
    </ThemeProvider>
  );
}

export default App;
