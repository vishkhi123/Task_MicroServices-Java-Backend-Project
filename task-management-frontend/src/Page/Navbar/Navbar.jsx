import { Avatar } from '@mui/material'
import "./Navbar.css"
import React from 'react'

const Navbar = () => {
    return (
        <div className='container z-10 sticky left-0 right-0 top-0 py-3 px-5
         lg:px-10, flex justify-between'>
            
            <p className='font-bold text-lg'>Vish Task Manager</p>

            <div className='flex items-center gap-5'>
                <p>Code With Vish</p>
                {/* <Avatar sx={{backgroundColor:"#c24dd0"}} >V</Avatar> */}
                <Avatar src='https://avatars.githubusercontent.com/u/114688411?v=4' >V</Avatar>
            </div>

        </div>
      );
    };

export default Navbar
