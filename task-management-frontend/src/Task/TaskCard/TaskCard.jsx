import { IconButton, Menu, MenuItem } from '@mui/material'
import React, { useState } from 'react'
import MoreVertIcon from '@mui/icons-material/MoreVert';


const TaskCard = () => {
  const [anchorEl, setAnchorEl] = useState(null)
 
  const openMenu = Boolean(anchorEl);
  const handleMenuClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleMenuClose = () => {
    setAnchorEl(null);
  };
  return (
    <div>
      <div className='card lg:flex justify-between'>
        <div className='lg:flex gap-5 items-center space--2 w-[90%]
         lg:w-[70%]'>
         <div>
            <img 
            className='lg:w-[7rem] lg:h-[7rem] object-cover'
            src="https://cdn.pixabay.com/photo/2017/03/05/15/29/aston-martin-2118857_1280.jpg" 
            alt="" />
         </div>
         <div className='space-y-5'>
                <div className='space-y-2'>
                    <h1 className='font-bold text-lg'>Car Rental Website</h1>
                    <p className='text-gray-500 text-sm'>use latest frameworks and technology to make this  website</p>
                </div>
                <div className='flex flex-wrap gap-2 items-center'>
                    {[1,1,1,1].map((item)=><span className='py-1 px-5 rounded-full techStack'>
                        Angular
                    </span>)}
                </div>
         </div>

        </div>
        <div>
          <IconButton 
          id="basic-button"
        aria-controls={openMenu ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={openMenu ? 'true' : undefined}
        onClick={handleMenuClick}
          >
            <MoreVertIcon/>
          </IconButton>
          
          <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={openMenu}
        onClose={handleMenuClose}
        MenuListProps={{
          'aria-labelledby': 'basic-button',
        }}
      >
        <MenuItem onClick={handleMenuClose}>Profile</MenuItem>
        <MenuItem onClick={handleMenuClose}>My account</MenuItem>
        <MenuItem onClick={handleMenuClose}>Logout</MenuItem>
      </Menu>
          
          
          
          
          

        </div>

      </div>
    </div>
  )
}

export default TaskCard
