import { useContactoMascota } from "../../hooks/useContactoMascota";
import { LastPetsCards } from "./LastPetsCards";

const Banner = () => {
  const { lastPets } = useContactoMascota();

  const renderPets = () => {
    if (lastPets.length > 0) {
      return lastPets.map((pet) => <LastPetsCards key={pet.id} pet={pet} />);
    }
  };

  return (
    <section className="bg-red-primary pb-10">
      <h1 className="text-3xl md:text-5xl font-bold text-center text-white py-6">
        Últimas mascotas <br /> reportadas
      </h1>
      <div className="grid gap-10 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1240px] mx-auto items-center">
        {renderPets()}
      </div>
    </section>
  );
};

export default Banner;
