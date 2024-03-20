import React from 'react'
import TaskCard from '../../Task/TaskCard/TaskCard'

const Tasklist = () => {
  return (
    <div className='space-y-5 w-[67vw]'>
      
      <div className='space-y-3'>
      {
        [1,1,1,1].map((item)=><TaskCard/>)
      }
      </div>

    </div>
  )
}

export default Tasklist
