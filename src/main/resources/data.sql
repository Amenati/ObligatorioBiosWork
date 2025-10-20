CREATE PROCEDURE IF NOT EXISTS cargar_datos_iniciales()
BEGIN
    IF NOT EXISTS (
        SELECT *
        FROM logs
    ) THEN
      INSERT INTO roles(nombre_rol)
        VALUES
            ('CONSULTOR'),
            ('CLIENTE'),
            ('POSTULANTE');
        INSERT INTO usuarios(nombre_usuario,activo,contraseña)
        VALUES
            ('admin',1, '$2a$10$1rEWITvNv6bKTBqjWcALeeLwISi52bL57RDOd4Pj8132mC0OhMWW2'),
            ('empuno',1, '$2a$12$sylSTt0B2d.c0dOnzOEuGOgiroxRJ3tpg28oN1IfrZWDhDXybRV7u');

        INSERT INTO usuarios_rol(usuario_nombre_usuario, rol_nombre_rol)
        VALUES
            ('admin', 1),
            ('empuno', 2);
        INSERT INTO logs(fecha_hora, mensaje)
        VALUES (NOW(), 'Datos iniciales cargados.');
    END IF;
END^;

CALL cargar_datos_iniciales()^;
