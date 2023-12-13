import React from 'react'

const PetCard = ({pet}) => {
    //console.log(pet)
  return (
    <article className="bg-white rounded-md overflow-hidden ligthTheme darkTheme">
      <header className="h-[160px] ligthTheme">
        {/* <img className="h-[100vh] w-full object-cover object-center" src={country.flags.svg} alt="" /> */}
      </header>
      <section className="p-2 py-4">
        {/* <h3 className="font-bold mb-2 text-lg line-clamp-1">{country.name.common}</h3> */}
        <ul>
          {/* <li><span className="font-semibold">Population:</span> {country.population}</li>
          <li><span className="font-semibold">Region:</span> {country.region}</li>
          <li><span className="font-semibold">Capital:</span> {country.capital ?? "N/A"}</li> */}
        </ul>
      </section>
    </article>
  )
}

export default PetCard