import React from "react";

const Banner = () => {
  return (
    <section className="bg-red-primary">
      <h1 className="text-5xl font-bold text-center text-white pt-6">
        Últimas mascotas reportadas
      </h1>
      <div className="grid gap-10 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1240px] mx-auto items-center py-16">
        {/* ----> Acá va renderizar las ultimas mascotas reportadas <------  */}

        <img className="max-h-[800px]" src="/images/nua.png" alt="" />
        <img className=" max-h-[800px]" src="/images/nua.png" alt="" />
        <img className=" max-h-[800px]" src="/images/nua.png" alt="" />
      </div>
    </section>
  );
};

export default Banner;
