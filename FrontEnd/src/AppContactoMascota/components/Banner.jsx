import React from "react";

const Banner = () => {
  return (
    <div className="bg-red-primary  pt-10 grid gap-10 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1240px] mx-auto items-center pb-7">

       {/* ----> Acá va renderizar las ultimas mascotas reportadas <------  */}

      <img
        className="max-h-[500px]"
        src="/images/nua.png"
        alt=""
      />
      <img
        className=" max-h-[500px]"
        src="/images/nua.png"
        alt=""
      />
      <img
        className=" max-h-[500px]"
        src="/images/nua.png"
        alt=""
      />
    </div>
  );
};

export default Banner;
