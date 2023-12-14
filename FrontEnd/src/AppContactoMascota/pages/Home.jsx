import Layout from "../../ui/Layout";
import Banner from "../components/Banner";
import ListPets from "../components/ListPets";
import Testimonial from "../components/Testimonial";

export const Home = () => {
  return (
    <Layout>
      <Banner />
      <ListPets />
      <Testimonial />
    </Layout>
  );
};
