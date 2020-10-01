package guru.springframework.sfgpetclinic.BootStrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class LoadData implements CommandLineRunner{
    private  final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeServices;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public LoadData(OwnerService ownerService, VetService vetService, PetTypeService PetTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeServices = PetTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }
    @Override
    public void run(String... args) throws Exception {
        int count=petTypeServices.findAll().size();
        if(count==0) {
            LoadData();
        }

    }

    private void LoadData() {
        PetType cat=new PetType();
        cat.setName("cat");
        PetType catSave=petTypeServices.save(cat);

        PetType dog=new PetType();
        dog.setName("dog");
        PetType dogsave=petTypeServices.save(dog);


        owner owner1= new owner();
        owner1.setId(1L);
        owner1.setFirstName("Goli");
        owner1.setLastName("Teymouri");
        owner1.setAddress("Kesklinn 10151");
        owner1.setCity("Tallin");
        owner1.setPhone("37255979514");

        Pet pet1=new Pet();
        pet1.setName("Dorry");
        pet1.setBirthday(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setPetType(dogsave);

        owner1.getPets().add(pet1);


        ownerService.save(owner1);
visit dogvisit=new visit();
dogvisit.setPet(pet1);
dogvisit.setDescription("sneezy dog");
dogvisit.setDate(LocalDate.now());
visitService.save(dogvisit);

        owner owner2= new owner();
        owner2.setFirstName("mahdi");
        owner2.setLastName("Karaz");
        owner2.setAddress("Manaee p 1");
        owner2.setCity("Tehran");
        owner2.setPhone("09125867140");

        Pet pet2=new Pet();
        pet2.setName("hope");
        pet2.setBirthday(LocalDate.now());
        pet2.setOwner(owner1);
        pet2.setPetType(catSave);

        owner2.getPets().add(pet2);
        ownerService.save(owner2);


        vet vet1=new vet();
        vet1.setFirstName("misha");
        vet1.setLastName("rohani");

        Speciality Surgery=new Speciality();
        Surgery.setDescription("Surgery");
        specialitiesService.save(Surgery);
        vet1.getSpecialities().add(Surgery);
        vetService.save(vet1);

        vet vet2=new vet();
        vet2.setId(2L);
        vet2.setFirstName("maryam");
        vet2.setLastName("asghari");


        Speciality Dentistry=new Speciality();
        Dentistry.setDescription("Dentistry");
        vet2.getSpecialities().add(Dentistry);
        specialitiesService.save(Dentistry);

        this.vetService.save(vet2);

        System.out.println("Loading vets");



        owner owner3= new owner();
        owner3.setId(3L);
        owner3.setFirstName("Parsa");
        owner3.setLastName("Teymouri");
        owner3.setAddress("Kesklinn 10151");
        owner3.setCity("Tehran");
        owner3.setPhone("22618976");

        Pet pet3=new Pet();
        pet3.setName("goofy");
        pet3.setBirthday(LocalDate.now());
        pet3.setOwner(owner3);
        pet3.setPetType(dogsave);

        owner3.getPets().add(pet3);


        ownerService.save(owner3);
        visit dogvisit3=new visit();
        dogvisit3.setPet(pet3);
        dogvisit3.setDescription("sneezy dog");
        dogvisit3.setDate(LocalDate.now());
        visitService.save(dogvisit);
    }
}
