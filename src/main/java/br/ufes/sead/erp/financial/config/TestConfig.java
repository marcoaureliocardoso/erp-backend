package br.ufes.sead.erp.financial.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufes.sead.erp.financial.entities.Contract;
import br.ufes.sead.erp.financial.entities.ContractEvent;
import br.ufes.sead.erp.financial.entities.ContractEventNote;
import br.ufes.sead.erp.financial.entities.Course;
import br.ufes.sead.erp.financial.entities.Employee;
import br.ufes.sead.erp.financial.entities.Grantor;
import br.ufes.sead.erp.financial.entities.Project;
import br.ufes.sead.erp.financial.entities.enums.EventType;
import br.ufes.sead.erp.financial.repositories.ContractEventRepository;
import br.ufes.sead.erp.financial.repositories.ContractRepository;
import br.ufes.sead.erp.financial.repositories.CourseRepository;
import br.ufes.sead.erp.financial.repositories.EmployeeRepository;
import br.ufes.sead.erp.financial.repositories.GrantorRepository;
import br.ufes.sead.erp.financial.repositories.ProjectRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

        @Autowired
        private GrantorRepository grantorRepository;
        @Autowired
        private CourseRepository courseRepository;
        @Autowired
        private ProjectRepository projectRepository;
        @Autowired
        private EmployeeRepository employeeRepository;
        @Autowired
        private ContractRepository contractRepository;
        @Autowired
        private ContractEventRepository contractEventRepository;

        @Override
        public void run(String... args) throws Exception {

                Grantor g1 = new Grantor(null, "Tech Innovations Inc.");
                Grantor g2 = new Grantor(null, "Global Health Foundation");
                Grantor g3 = new Grantor(null, "Cybernetics Corp.");
                Grantor g4 = new Grantor(null, "Oceanic Preservation Society");
                Grantor g5 = new Grantor(null, "Future Tech Leaders");
                Grantor g6 = new Grantor(null, "Urban Development Group");
                Grantor g7 = new Grantor(null, "International Art Council");
                Grantor g8 = new Grantor(null, "Sustainable Agriculture Network");
                Grantor g9 = new Grantor(null, "Space Exploration Collective");
                Grantor g10 = new Grantor(null, "Quantum Computing Lab");
                Grantor g11 = new Grantor(null, "Historical Society");
                Grantor g12 = new Grantor(null, "Global Linguistics Forum");
                Grantor g13 = new Grantor(null, "Ocean Cleanup Initiative");
                Grantor g14 = new Grantor(null, "Cyber Security Alliance");
                Grantor g15 = new Grantor(null, "Artificial Intelligence Institute");

                grantorRepository.saveAll(
                                Arrays.asList(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15));

                Course c1 = new Course(null, "Renewable Energy Engineering");
                Course c2 = new Course(null, "Medical Biotechnology");
                Course c3 = new Course(null, "Artificial Intelligence and Ethics");
                Course c4 = new Course(null, "Marine Biology and Conservation");
                Course c5 = new Course(null, "Advanced Robotics and AI");
                Course c6 = new Course(null, "Urban Planning and Sustainability");
                Course c7 = new Course(null, "Art History and Restoration");
                Course c8 = new Course(null, "Sustainable Agriculture Practices");
                Course c9 = new Course(null, "Astrophysics and Space Engineering");
                Course c10 = new Course(null, "Quantum Information Science");
                Course c11 = new Course(null, "Archaeology and Anthropology");
                Course c12 = new Course(null, "Linguistics and Language Preservation");
                Course c13 = new Course(null, "Environmental Sciences and Policy");
                Course c14 = new Course(null, "Cybersecurity and Digital Forensics");
                Course c15 = new Course(null, "Health Informatics and AI");

                courseRepository.saveAll(
                                Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15));

                Project p1 = new Project(null, "Green Energy Solutions", "GES001", g1, LocalDate.parse("2019-02-01"),
                                LocalDate.parse("2020-02-01"));
                Project p2 = new Project(null, "Vaccine Research Program", "VRP002", g2, LocalDate.parse("2018-05-01"),
                                LocalDate.parse("2019-05-01"));
                Project p3 = new Project(null, "AI for Good Initiative", "AGI003", g3, LocalDate.parse("2021-07-01"),
                                LocalDate.parse("2022-07-01"));
                Project p4 = new Project(null, "Marine Biodiversity Project", "MBP004", g4,
                                LocalDate.parse("2017-03-01"),
                                LocalDate.parse("2018-03-01"));
                Project p5 = new Project(null, "Youth Robotics Program", "YRP005", g5, LocalDate.parse("2022-10-01"),
                                LocalDate.parse("2023-10-01"));
                Project p6 = new Project(null, "Smart Cities Initiative", "SCI006", g6, LocalDate.parse("2020-12-01"),
                                LocalDate.parse("2021-12-01"));
                Project p7 = new Project(null, "Cultural Heritage Preservation", "CHP007", g7,
                                LocalDate.parse("2019-11-01"),
                                LocalDate.parse("2020-11-01"));
                Project p8 = new Project(null, "Organic Farming Expansion", "OFE008", g8, LocalDate.parse("2021-04-01"),
                                LocalDate.parse("2022-04-01"));
                Project p9 = new Project(null, "Mars Habitat Simulation", "MHS009", g9, LocalDate.parse("2019-07-01"),
                                LocalDate.parse("2020-07-01"));
                Project p10 = new Project(null, "Quantum Algorithms Research", "QAR010", g10,
                                LocalDate.parse("2022-01-01"),
                                LocalDate.parse("2023-01-01"));
                Project p11 = new Project(null, "Ancient Civilizations Study", "ACS011", g11,
                                LocalDate.parse("2020-09-01"),
                                LocalDate.parse("2021-09-01"));
                Project p12 = new Project(null, "Endangered Languages Documentation", "ELD012", g12,
                                LocalDate.parse("2018-06-01"), LocalDate.parse("2019-06-01"));
                Project p13 = new Project(null, "Plastic Pollution Reduction", "PPR013", g13,
                                LocalDate.parse("2021-05-01"),
                                LocalDate.parse("2022-05-01"));
                Project p14 = new Project(null, "Data Protection Strategy", "DPS014", g14,
                                LocalDate.parse("2019-08-01"),
                                LocalDate.parse("2020-08-01"));
                Project p15 = new Project(null, "AI in Healthcare", "AIH015", g15, LocalDate.parse("2022-03-01"),
                                LocalDate.parse("2023-03-01"));

                projectRepository.saveAll(
                                Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

                Employee e1 = new Employee(null, "John", "Doe", "12345756789", LocalDate.parse("1990-01-15"),
                                "john.doe@example.net");
                Employee e2 = new Employee(null, "Jane", "Smith", "98765754321", LocalDate.parse("1988-05-20"),
                                "jane.smith@example.net");
                Employee e3 = new Employee(null, "Jack", "Black", "12315723123", LocalDate.parse("1995-12-31"),
                                "jack.black@example.net");
                Employee e4 = new Employee(null, "Jill", "White", "32135721321", LocalDate.parse("1993-06-30"),
                                "jill.white@example.net");
                Employee e5 = new Employee(null, "Jim", "Green", "45576456456", LocalDate.parse("1991-03-15"),
                                "jim.green@example.net");
                Employee e6 = new Employee(null, "Jenny", "Brown", "65465574654", LocalDate.parse("1994-09-15"),
                                "jenny.brown@example.net");
                Employee e7 = new Employee(null, "Joe", "Grey", "78978579789", LocalDate.parse("1992-07-31"),
                                "joe.grey@example.net");
                Employee e8 = new Employee(null, "Jessica", "Blue", "98795787987", LocalDate.parse("1996-11-30"),
                                "jessica.blue@example.net");
                Employee e9 = new Employee(null, "James", "Red", "15915579159", LocalDate.parse("1997-02-28"),
                                "james.red@example.net");
                Employee e10 = new Employee(null, "Julia", "Purple", "95195751951", LocalDate.parse("1998-10-31"),
                                "julia.purple@example.net");
                Employee e11 = new Employee(null, "Jason", "Yellow", "75375357753", LocalDate.parse("1999-04-30"),
                                "jason.yellow@example.net");
                Employee e12 = new Employee(null, "Jasmine", "Orange", "35735757357", LocalDate.parse("2000-08-31"),
                                "jasmine.orange@example.net");
                Employee e13 = new Employee(null, "Justin", "Cyan", "25825578258", LocalDate.parse("2001-01-31"),
                                "justin.cyan@example.net");
                Employee e14 = new Employee(null, "Jade", "Magenta", "85285257852", LocalDate.parse("2002-05-31"),
                                "jade.magenta@example.net");
                Employee e15 = new Employee(null, "Jasper", "Violet", "45645576456", LocalDate.parse("2003-09-30"),
                                "jasper.violet@example.net");

                employeeRepository.saveAll(
                                Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));

                Contract ct1 = new Contract(null, g1, p1, c1, e1, LocalDate.parse("2019-02-01"),
                                LocalDate.parse("2020-02-01"));
                Contract ct2 = new Contract(null, g2, p2, c2, e2, LocalDate.parse("2018-05-01"),
                                LocalDate.parse("2019-05-01"));
                Contract ct3 = new Contract(null, g3, p3, c3, e3, LocalDate.parse("2021-07-01"),
                                LocalDate.parse("2022-07-01"));
                Contract ct4 = new Contract(null, g4, p4, c4, e4, LocalDate.parse("2017-03-01"),
                                LocalDate.parse("2018-03-01"));
                Contract ct5 = new Contract(null, g5, p5, c5, e5, LocalDate.parse("2022-10-01"),
                                LocalDate.parse("2023-10-01"));
                Contract ct6 = new Contract(null, g6, p6, c6, e6, LocalDate.parse("2020-12-01"),
                                LocalDate.parse("2021-12-01"));
                Contract ct7 = new Contract(null, g7, p7, c7, e7, LocalDate.parse("2019-11-01"),
                                LocalDate.parse("2020-11-01"));
                Contract ct8 = new Contract(null, g8, p8, c8, e8, LocalDate.parse("2021-04-01"),
                                LocalDate.parse("2022-04-01"));
                Contract ct9 = new Contract(null, g9, p9, c9, e9, LocalDate.parse("2019-07-01"),
                                LocalDate.parse("2020-07-01"));
                Contract ct10 = new Contract(null, g10, p10, c10, e10, LocalDate.parse("2022-01-01"),
                                LocalDate.parse("2023-01-01"));
                Contract ct11 = new Contract(null, g11, p11, c11, e11, LocalDate.parse("2020-09-01"),
                                LocalDate.parse("2021-09-01"));
                Contract ct12 = new Contract(null, g12, p12, c12, e12, LocalDate.parse("2018-06-01"),
                                LocalDate.parse("2019-06-01"));
                Contract ct13 = new Contract(null, g13, p13, c13, e13, LocalDate.parse("2021-05-01"),
                                LocalDate.parse("2022-05-01"));
                Contract ct14 = new Contract(null, g14, p14, c14, e14, LocalDate.parse("2019-08-01"),
                                LocalDate.parse("2020-08-01"));
                Contract ct15 = new Contract(null, g15, p15, c15, e15, LocalDate.parse("2022-03-01"),
                                LocalDate.parse("2023-03-01"));

                contractRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11, ct12,
                                ct13, ct14, ct15));

                ContractEvent ce1 = new ContractEvent(null, ct1, EventType.RECESS1, LocalDate.parse("2022-11-23"),
                                null); // id: 2
                ContractEvent ce2 = new ContractEvent(null, ct1, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2022-11-24"),
                                null); // id: 5
                ContractEvent ce3 = new ContractEvent(null, ct1, EventType.RECESS2, LocalDate.parse("2023-05-24"),
                                null); // id: 7
                ContractEvent ce4 = new ContractEvent(null, ct1, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2023-05-25"),
                                null); // id: 10
                ContractEvent ce5 = new ContractEvent(null, ct1, EventType.CONTRACT_END, LocalDate.parse("2023-07-09"),
                                null); // id: 12
                ContractEvent ce6 = new ContractEvent(null, ct2, EventType.RECESS1, LocalDate.parse("2025-03-07"),
                                null); // id: 15
                ContractEvent ce7 = new ContractEvent(null, ct2, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2025-03-08"),
                                null); // id: 18
                ContractEvent ce8 = new ContractEvent(null, ct2, EventType.RECESS2, LocalDate.parse("2025-09-07"),
                                null); // id: 20
                ContractEvent ce9 = new ContractEvent(null, ct2, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2025-09-08"),
                                null); // id: 23
                ContractEvent ce10 = new ContractEvent(null, ct2, EventType.CONTRACT_END, LocalDate.parse("2025-10-23"),
                                null); // id: 25
                ContractEvent ce11 = new ContractEvent(null, ct3, EventType.RECESS1, LocalDate.parse("2020-10-01"),
                                null); // id: 28
                ContractEvent ce12 = new ContractEvent(null, ct3, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2020-10-02"),
                                null); // id: 31
                ContractEvent ce13 = new ContractEvent(null, ct3, EventType.RECESS2, LocalDate.parse("2021-04-01"),
                                null); // id: 33
                ContractEvent ce14 = new ContractEvent(null, ct3, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2021-04-02"),
                                null); // id: 36
                ContractEvent ce15 = new ContractEvent(null, ct3, EventType.CONTRACT_END, LocalDate.parse("2021-05-17"),
                                null); // id: 38
                ContractEvent ce16 = new ContractEvent(null, ct4, EventType.RECESS1, LocalDate.parse("2024-12-10"),
                                null); // id: 41
                ContractEvent ce17 = new ContractEvent(null, ct4, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2024-12-11"),
                                null); // id: 44
                ContractEvent ce18 = new ContractEvent(null, ct4, EventType.RECESS2, LocalDate.parse("2025-06-10"),
                                null); // id: 46
                ContractEvent ce19 = new ContractEvent(null, ct4, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2025-06-11"),
                                null); // id: 49
                ContractEvent ce20 = new ContractEvent(null, ct4, EventType.CONTRACT_END, LocalDate.parse("2025-07-26"),
                                null); // id: 51
                ContractEvent ce21 = new ContractEvent(null, ct5, EventType.RECESS1, LocalDate.parse("2024-05-13"),
                                null); // id: 54
                ContractEvent ce22 = new ContractEvent(null, ct5, EventType.REPORT1_DELIVERY,
                                LocalDate.parse("2024-05-14"),
                                null); // id: 57
                ContractEvent ce23 = new ContractEvent(null, ct5, EventType.RECESS2, LocalDate.parse("2024-11-13"),
                                null); // id: 59
                ContractEvent ce24 = new ContractEvent(null, ct5, EventType.REPORT2_DELIVERY,
                                LocalDate.parse("2024-11-14"),
                                null); // id: 62
                ContractEvent ce25 = new ContractEvent(null, ct5, EventType.CONTRACT_END, LocalDate.parse("2024-12-29"),
                                null); // id: 64

                contractEventRepository.saveAll(Arrays.asList(ce1, ce2, ce3, ce4, ce5, ce6, ce7, ce8, ce9, ce10, ce11,
                                ce12, ce13, ce14, ce15, ce16, ce17, ce18, ce19, ce20, ce21, ce22, ce23, ce24, ce25));

                ContractEventNote ceNote1 = new ContractEventNote(1L, "Some notes 1.");
                ContractEventNote ceNote2 = new ContractEventNote(2L, "Some notes 2.");
                ContractEventNote ceNote3 = new ContractEventNote(3L, "Some notes 3.");
                ContractEventNote ceNote4 = new ContractEventNote(4L, "Some notes 4.");
                ContractEventNote ceNote5 = new ContractEventNote(5L, "Some notes 5.");
                ContractEventNote ceNote6 = new ContractEventNote(6L, "Some notes 6.");
                ContractEventNote ceNote7 = new ContractEventNote(7L, "Some notes 7.");
                ContractEventNote ceNote8 = new ContractEventNote(8L, "Some notes 8.");
                ContractEventNote ceNote9 = new ContractEventNote(9L, "Some notes 9.");
                ContractEventNote ceNote10 = new ContractEventNote(10L, "Some notes 10.");
                ContractEventNote ceNote11 = new ContractEventNote(11L, "Some notes 11.");
                ContractEventNote ceNote12 = new ContractEventNote(12L, "Some notes 12.");
                ContractEventNote ceNote13 = new ContractEventNote(13L, "Some notes 13.");
                ContractEventNote ceNote14 = new ContractEventNote(14L, "Some notes 14.");
                ContractEventNote ceNote15 = new ContractEventNote(15L, "Some notes 15.");
                ContractEventNote ceNote16 = new ContractEventNote(16L, "Some notes 16.");
                ContractEventNote ceNote17 = new ContractEventNote(17L, "Some notes 17.");
                ContractEventNote ceNote18 = new ContractEventNote(18L, "Some notes 18.");
                ContractEventNote ceNote19 = new ContractEventNote(19L, "Some notes 19.");
                ContractEventNote ceNote20 = new ContractEventNote(20L, "Some notes 20.");
                ContractEventNote ceNote21 = new ContractEventNote(21L, "Some notes 21.");
                ContractEventNote ceNote22 = new ContractEventNote(22L, "Some notes 22.");
                ContractEventNote ceNote23 = new ContractEventNote(23L, "Some notes 23.");
                ContractEventNote ceNote24 = new ContractEventNote(24L, "Some notes 24.");
                ContractEventNote ceNote25 = new ContractEventNote(25L, "Some notes 25.");

                ce1.setNote(ceNote1);
                ce2.setNote(ceNote2);
                ce3.setNote(ceNote3);
                ce4.setNote(ceNote4);
                ce5.setNote(ceNote5);
                ce6.setNote(ceNote6);
                ce7.setNote(ceNote7);
                ce8.setNote(ceNote8);
                ce9.setNote(ceNote9);
                ce10.setNote(ceNote10);
                ce11.setNote(ceNote11);
                ce12.setNote(ceNote12);
                ce13.setNote(ceNote13);
                ce14.setNote(ceNote14);
                ce15.setNote(ceNote15);
                ce16.setNote(ceNote16);
                ce17.setNote(ceNote17);
                ce18.setNote(ceNote18);
                ce19.setNote(ceNote19);
                ce20.setNote(ceNote20);
                ce21.setNote(ceNote21);
                ce22.setNote(ceNote22);
                ce23.setNote(ceNote23);
                ce24.setNote(ceNote24);
                ce25.setNote(ceNote25);

                contractEventRepository.saveAll(Arrays.asList(ce1, ce2, ce3, ce4, ce5, ce6, ce7, ce8, ce9, ce10, ce11,
                                ce12, ce13, ce14, ce15, ce16, ce17, ce18, ce19, ce20, ce21, ce22, ce23, ce24, ce25));
        }

}
