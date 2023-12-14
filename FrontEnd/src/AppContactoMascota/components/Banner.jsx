const Banner = () => {
  return (
    <section className="bg-red-primary pb-10">
      <h1 className="text-5xl font-bold text-center text-white py-6">
        Últimas mascotas reportadas
      </h1>
      <div className="grid gap-10 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1240px] mx-auto items-center">
        {/* ----> Acá va renderizar las ultimas mascotas reportadas <------  */}

        <img className="max-h-[800px]" src="/images/nua.png" alt="" />
        <img className=" max-h-[800px]" src="/images/nua.png" alt="" />
        <img className=" max-h-[800px]" src="/images/nua.png" alt="" />
      </div>
    </section>
  );
};

export default Banner;
