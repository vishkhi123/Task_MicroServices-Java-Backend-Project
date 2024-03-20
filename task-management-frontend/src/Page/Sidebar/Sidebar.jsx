import { Avatar, Button } from '@mui/material'
import React, { useState } from 'react'
import "./Sidebar.css"

const menu=[
    {name:"HOME",value:"HOME",role:["ROLE_ADMIN","ROLE_CUSTOMER"]},
    {name:"DONE",value:"DONE",role:["ROLE_ADMIN","ROLE_CUSTOMER"]},
    {name:"ASSIGNED",value:"ASSIGNED",role:["ROLE_ADMIN"]},
    {name:"NOT ASSIGNED",value:"PENDING",role:["ROLE_ADMIN"]},
    {name:"CREATE NEW TASK",value:"",role:["ROLE_ADMIN"]},
    {name:"NOTIFICATION",value:"NOTIFICATION",role:["ROLE_CUSTOMER"]}
]

const role="ROLE_ADMIN"

const Sidebar = () => {

    const [activeMenu,setActiveMenu]=useState("HOME")

    const handelMenuChange=(item)=>{
        setActiveMenu(item.name)
    }

    const handelLogout=()=>{
        alert("Logout Successfully")
    }
  
    return (
    <div className='card min-h-[85vh] flex flex-col justify-center fixed w-[20vw]'>
      <div className='space-y-5 h-full'>

      <div className='flex justify-center'>
        <Avatar 
        sx={{width:"8rem",height:"8rem"}}
        className='border-2 border-[#c24dd0]'
        src='https://avatars.githubusercontent.com/u/114688411?v=4'/>
      </div>
      {
        menu.filter((item)=>item.role.includes(role))
        .map((item)=><p onClick={()=>handelMenuChange(item)} className={`py-3 px-5 rounded-full text-center
          cursor-pointer ${activeMenu===item.name ? "activeMenuItem":"menuItem"}`}>
            {item.name}
        </p>)
      }
      <Button onClick={handelLogout} sx={{padding:".7rem",borderRadius:"2rem"}} fullWidth className='logoutButton'>
        Logout
      </Button>

      </div>
      
    </div>
  )
}

export default Sidebar
