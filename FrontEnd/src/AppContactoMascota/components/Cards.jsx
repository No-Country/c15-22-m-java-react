import React from "react";

const Cards = () => {
  return (
    <section className="mb-10">
      <div className=" w-[300px] h-[530px] bg-base-100 shadow-xl">
        <figure className="px-3 pt-3 border mb-4">
          <img
            src="/images/blanquis.jpg"
            alt="Shoes"
            className="rounded-xl"
          />
        </figure>
        <div className="card-body items-center text-center">
          <h3 className="card-title">Perdido</h3>
          <h3 className="text-xl font-semibold">Nombre mascota</h3>
          <p className="mb-5">Informacion de donde fue visto</p>
          <div className="flex justify-between px-5 ">
            <button className="border w-[110px] bg-[#FFD6A5] inline-block rounded 
            pb-[6px] pt-2 text-sm font-medium  transition duration-150 ease-in-out hover:bg-neutral-500 hover:bg-opacity-10 ">Ver datos</button>
            <button className="border w-[110px] bg-[#FFD6A5] inline-block rounded 
            pb-[6px] pt-2 text-sm font-medium  transition duration-150 ease-in-out hover:bg-neutral-500 hover:bg-opacity-10  ">Compartir</button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Cards;
