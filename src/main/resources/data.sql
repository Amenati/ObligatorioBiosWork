CREATE PROCEDURE IF NOT EXISTS cargar_datos_iniciales()
BEGIN
    IF NOT EXISTS (
        SELECT *
        FROM Departamentos
    ) THEN
        INSERT INTO usuarios(nombre_usuario, contrasena)
        VALUES
            ("usuario1", "111AAA"),
            ("usuario2", "222AAA"),
            ("usuario3", "333AAA"),
            ("usuario4", "444BBB"),
            ("usuario5", "555BBB"),
            ("usuario6", "666BBB"),
            ("usuario7", "777CCC"),
            ("usuario8", "888CCC"),
            ("usuario9", "999CCC");


        INSERT INTO consultores(nombre_usuario)
        VALUES
            ("usuario1"),
            ("usuario2"),
            ("usuario3");
            
        INSERT INTO clientes(nombre_usuario, rut, nombre, url)
        VALUES
            ("usuario4", "123456789012", "Vidal S.A", "www.vidalsa.com.uy"),
            ("usuario5", "098765432109", "Encur SRL", null),
            ("usuario6", "234567890123", "Kennametal S.A.", "www.kennametal.com");
            
        INSERT INTO postulantes(nombre_usuario, cedula, nombre_completo, fecha_nacimiento, departamento_residencia, tiene_imagen, tiene_curriculum)
        VALUES
            ("usuario7", "49754321", "Luis Gonzalez","19861023","Montevideo", true, true ),
            ("usuario8", "34567895", "Ana Lemes","19810801","San José", true, false ),
            ("usuario9", "53682154", "Claudio Nieto","20001210","Lavalleja", false, false );

        INSERT INTO areas(id, nombre)
        VALUES
            (null, 'Ventas'),
            (null, 'Tecnologías de la información'),
            (null, 'Atención al cliente'),
            (null, 'Ingeniería'),
            (null, 'Diseño'),
            (null, 'Distribución'),
            (null, 'Recursos Humanos'),
            (null, 'Construcción'),
            (null, 'Finanzas'),
            (null, 'Contabilidad'),
            (null, 'Administración'),
            (null, 'Limpieza');

        INSERT INTO ofertas_trabajo(id, fecha_publicacion, fecha_cierre, titulo, descripcion, puestos_vacantes, area_id, cliente_nombre_usuario)
        VALUES
            (null, '20250809', '20250909', 'Operador de Servicios', 'Nos orientamos a candidatas/os que cuenten con: Curso de Auxiliar de Servicio y/o experiencia en limpieza y manipulación de alimentos.', 2, 12, 'usuario4'),
            (null, '20250901', '20251212', 'Ejecutivo Comercial', 'Buscamos personas con perfil 100% comercial, con iniciativa para generar oportunidades en calle , concretar reuniones, y cerrar acuerdos con comercios de mediano y gran porte.', 1, 1, 'usuario4'),
            (null, '20250103', '20251009', 'Técnico en Seguridad Electrónica', 'La posición implica realizar tareas de cableado, instalación y mantenimiento de sistemas de seguridad electrónica (CCTV, detección de incendios y controles de accesos).', 4, 12, 'usuario5'),
            (null, '20250506', '20251102', 'Especialista en mejoras y gestión de proyectos', 'La posición está orientada a profesionales (o estudiantes avanzados) de Ingeniería, Administración, Sistemas, Ciencias Económicas o afines, con interés en la gestión de proyectos y el uso de tecnología para mejorar procesos (BPMS).', 2, 1, 'usuario5'),
            (null, '20250818', '20251130', 'Vendedor/a de plaza', 'Se busca vendedor/a, con vehículo propio. Para importadora y distribuidora, con más de 10 años en el rubro de los alimentos congelados, ubicados en las cercanías de malvín norte.', 3, 1, 'usuario6');
               
 
        INSERT INTO postulaciones(fecha_postulacion, oferta_trabajo_id, postulante_nombre_usuario)
        VALUES
            ("20250815", 1, "usuario7"),
            ("20250810", 2, "usuario8"),
            ("20250901", 5, "usuario7"),
            ("20250606", 4, "usuario9");

        INSERT INTO departamentos(nombre)
        VALUES 
            ("Artigas"),
            ("Salto"),
            ("Paysandú"),
            ("Río Negro"),
            ("Soriano"),
            ("Colonia"),
            ("San José"),
            ("Rivera"),
            ("Tacuarembó"),
            ("Durazno"),
            ("Flores"),
            ("Florida"),
            ("Canelones"),
            ("Montevideo"),
            ("Cerro Largo"),
            ("Rocha"),
            ("Lavalleja"),
            ("Maldonado"),
            ("Treinta y Tres");
    END IF;
END^;
 
CALL cargar_datos_iniciales()^;