import React, { useState } from 'react'
import { axiosMascota } from '../../config/axios.config'
import PetCard from './PetCard'

const ListPets = () => {
    const [pets, setPets] = useState([])

    axiosMascota
    
        .get("/api/v1/pets?size=10&page=0&sort=name,asc")
        .then(({data}) => setPets(data))
        .catch((err) => console.log(err))
        console.log(data)
        
        
  return (
    <section className=" pt-10 grid gap-6 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1200px] mx-auto">
    {
      pets.map((pet) => <PetCard key={pet} pet={pet} />)
      
    }
    
  </section>
  
  )
}

export default ListPets