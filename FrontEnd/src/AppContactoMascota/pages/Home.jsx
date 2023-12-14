import Layout from "../../ui/Layout";
import Banner from "../components/Banner";
import ListPets from "../components/ListPets";
import Testimonial from "../components/Testimonial";

export const Home = () => {
  return (
    <Layout>
      <Banner />
      <ListPets />
      <h2 className="text-5xl font-bold text-center my-5">Historias con finales felices</h2>
      <Testimonial />
    </Layout>
  );
};
