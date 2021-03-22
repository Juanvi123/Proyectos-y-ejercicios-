namespace Gestion_Television_Juan_Vicente_Sanchez_Reyes.Formularios
{
    partial class Frm_Contenidos_Eventos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.GB_Titulo_Descripcion = new System.Windows.Forms.GroupBox();
            this.Lbl_Titulo_Traducido = new System.Windows.Forms.Label();
            this.Cmb_Titulos = new System.Windows.Forms.ComboBox();
            this.Btn_Buscar = new System.Windows.Forms.Button();
            this.TbC_Contenidos_Eventos = new System.Windows.Forms.TabControl();
            this.TbP_Contenidos = new System.Windows.Forms.TabPage();
            this.TbP_Eventos = new System.Windows.Forms.TabPage();
            this.Lbl_Titulo_Original = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.Pais_Produccion = new System.Windows.Forms.Label();
            this.Lbl_Genero = new System.Windows.Forms.Label();
            this.Lbl_Rating = new System.Windows.Forms.Label();
            this.Lbl_Actores = new System.Windows.Forms.Label();
            this.Lbl_Direccion = new System.Windows.Forms.Label();
            this.Lbl_Sinopsis = new System.Windows.Forms.Label();
            this.R_Txt_Sinopsis = new System.Windows.Forms.RichTextBox();
            this.Lbl_Anio_Produccion = new System.Windows.Forms.Label();
            this.Lbl_Subgenero = new System.Windows.Forms.Label();
            this.Lbl_Duracion = new System.Windows.Forms.Label();
            this.Txt_Actores = new System.Windows.Forms.TextBox();
            this.Txt_Direccion = new System.Windows.Forms.TextBox();
            this.Txt_Duracion = new System.Windows.Forms.TextBox();
            this.Txt_Anio_Produccion = new System.Windows.Forms.TextBox();
            this.Cmb_Pais_Produccion = new System.Windows.Forms.ComboBox();
            this.Cmb_Genero = new System.Windows.Forms.ComboBox();
            this.Cmb_Rating = new System.Windows.Forms.ComboBox();
            this.CmB_SubGenero = new System.Windows.Forms.ComboBox();
            this.Btn_Nuevo = new System.Windows.Forms.Button();
            this.Btn_Guardar = new System.Windows.Forms.Button();
            this.Btn_Borrar = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.DGV_Eventos = new System.Windows.Forms.DataGridView();
            this.C_Canal = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.C_Fecha = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.C_Hora = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.C_Codificado = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.GB_Titulo_Descripcion.SuspendLayout();
            this.TbC_Contenidos_Eventos.SuspendLayout();
            this.TbP_Contenidos.SuspendLayout();
            this.TbP_Eventos.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.DGV_Eventos)).BeginInit();
            this.SuspendLayout();
            // 
            // GB_Titulo_Descripcion
            // 
            this.GB_Titulo_Descripcion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.GB_Titulo_Descripcion.Controls.Add(this.Btn_Buscar);
            this.GB_Titulo_Descripcion.Controls.Add(this.Cmb_Titulos);
            this.GB_Titulo_Descripcion.Controls.Add(this.Lbl_Titulo_Traducido);
            this.GB_Titulo_Descripcion.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.GB_Titulo_Descripcion.Location = new System.Drawing.Point(40, 23);
            this.GB_Titulo_Descripcion.Name = "GB_Titulo_Descripcion";
            this.GB_Titulo_Descripcion.Size = new System.Drawing.Size(721, 105);
            this.GB_Titulo_Descripcion.TabIndex = 0;
            this.GB_Titulo_Descripcion.TabStop = false;
            this.GB_Titulo_Descripcion.Text = "Titulo/Descripción";
            // 
            // Lbl_Titulo_Traducido
            // 
            this.Lbl_Titulo_Traducido.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Titulo_Traducido.AutoSize = true;
            this.Lbl_Titulo_Traducido.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Titulo_Traducido.Location = new System.Drawing.Point(19, 37);
            this.Lbl_Titulo_Traducido.Name = "Lbl_Titulo_Traducido";
            this.Lbl_Titulo_Traducido.Size = new System.Drawing.Size(86, 13);
            this.Lbl_Titulo_Traducido.TabIndex = 0;
            this.Lbl_Titulo_Traducido.Text = "Título Traducido";
            // 
            // Cmb_Titulos
            // 
            this.Cmb_Titulos.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Cmb_Titulos.FormattingEnabled = true;
            this.Cmb_Titulos.Location = new System.Drawing.Point(144, 37);
            this.Cmb_Titulos.Name = "Cmb_Titulos";
            this.Cmb_Titulos.Size = new System.Drawing.Size(422, 21);
            this.Cmb_Titulos.TabIndex = 1;
            // 
            // Btn_Buscar
            // 
            this.Btn_Buscar.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Btn_Buscar.Location = new System.Drawing.Point(605, 37);
            this.Btn_Buscar.Name = "Btn_Buscar";
            this.Btn_Buscar.Size = new System.Drawing.Size(75, 23);
            this.Btn_Buscar.TabIndex = 2;
            this.Btn_Buscar.Text = "Buscar";
            this.Btn_Buscar.UseVisualStyleBackColor = true;
            // 
            // TbC_Contenidos_Eventos
            // 
            this.TbC_Contenidos_Eventos.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.TbC_Contenidos_Eventos.Controls.Add(this.TbP_Contenidos);
            this.TbC_Contenidos_Eventos.Controls.Add(this.TbP_Eventos);
            this.TbC_Contenidos_Eventos.Font = new System.Drawing.Font("Franklin Gothic Medium", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TbC_Contenidos_Eventos.Location = new System.Drawing.Point(40, 134);
            this.TbC_Contenidos_Eventos.Name = "TbC_Contenidos_Eventos";
            this.TbC_Contenidos_Eventos.SelectedIndex = 0;
            this.TbC_Contenidos_Eventos.Size = new System.Drawing.Size(721, 566);
            this.TbC_Contenidos_Eventos.TabIndex = 1;
            // 
            // TbP_Contenidos
            // 
            this.TbP_Contenidos.Controls.Add(this.Btn_Borrar);
            this.TbP_Contenidos.Controls.Add(this.Btn_Guardar);
            this.TbP_Contenidos.Controls.Add(this.Btn_Nuevo);
            this.TbP_Contenidos.Controls.Add(this.CmB_SubGenero);
            this.TbP_Contenidos.Controls.Add(this.Cmb_Rating);
            this.TbP_Contenidos.Controls.Add(this.Cmb_Genero);
            this.TbP_Contenidos.Controls.Add(this.Cmb_Pais_Produccion);
            this.TbP_Contenidos.Controls.Add(this.Txt_Anio_Produccion);
            this.TbP_Contenidos.Controls.Add(this.Txt_Duracion);
            this.TbP_Contenidos.Controls.Add(this.Txt_Direccion);
            this.TbP_Contenidos.Controls.Add(this.Txt_Actores);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Duracion);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Subgenero);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Anio_Produccion);
            this.TbP_Contenidos.Controls.Add(this.R_Txt_Sinopsis);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Sinopsis);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Direccion);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Actores);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Rating);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Genero);
            this.TbP_Contenidos.Controls.Add(this.Pais_Produccion);
            this.TbP_Contenidos.Controls.Add(this.textBox1);
            this.TbP_Contenidos.Controls.Add(this.Lbl_Titulo_Original);
            this.TbP_Contenidos.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TbP_Contenidos.Location = new System.Drawing.Point(4, 33);
            this.TbP_Contenidos.Name = "TbP_Contenidos";
            this.TbP_Contenidos.Padding = new System.Windows.Forms.Padding(3);
            this.TbP_Contenidos.Size = new System.Drawing.Size(713, 529);
            this.TbP_Contenidos.TabIndex = 0;
            this.TbP_Contenidos.Text = "Contenidos";
            this.TbP_Contenidos.UseVisualStyleBackColor = true;
            // 
            // TbP_Eventos
            // 
            this.TbP_Eventos.Controls.Add(this.DGV_Eventos);
            this.TbP_Eventos.Location = new System.Drawing.Point(4, 33);
            this.TbP_Eventos.Name = "TbP_Eventos";
            this.TbP_Eventos.Padding = new System.Windows.Forms.Padding(3);
            this.TbP_Eventos.Size = new System.Drawing.Size(713, 529);
            this.TbP_Eventos.TabIndex = 1;
            this.TbP_Eventos.Text = "Eventos";
            this.TbP_Eventos.UseVisualStyleBackColor = true;
            // 
            // Lbl_Titulo_Original
            // 
            this.Lbl_Titulo_Original.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Titulo_Original.AutoSize = true;
            this.Lbl_Titulo_Original.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Titulo_Original.Location = new System.Drawing.Point(18, 37);
            this.Lbl_Titulo_Original.Name = "Lbl_Titulo_Original";
            this.Lbl_Titulo_Original.Size = new System.Drawing.Size(98, 15);
            this.Lbl_Titulo_Original.TabIndex = 0;
            this.Lbl_Titulo_Original.Text = "Título Original";
            // 
            // textBox1
            // 
            this.textBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textBox1.Location = new System.Drawing.Point(140, 37);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(524, 21);
            this.textBox1.TabIndex = 1;
            // 
            // Pais_Produccion
            // 
            this.Pais_Produccion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Pais_Produccion.AutoSize = true;
            this.Pais_Produccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Pais_Produccion.Location = new System.Drawing.Point(5, 85);
            this.Pais_Produccion.Name = "Pais_Produccion";
            this.Pais_Produccion.Size = new System.Drawing.Size(111, 15);
            this.Pais_Produccion.TabIndex = 3;
            this.Pais_Produccion.Text = "Pais Producción";
            // 
            // Lbl_Genero
            // 
            this.Lbl_Genero.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Genero.AutoSize = true;
            this.Lbl_Genero.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Genero.Location = new System.Drawing.Point(62, 125);
            this.Lbl_Genero.Name = "Lbl_Genero";
            this.Lbl_Genero.Size = new System.Drawing.Size(54, 15);
            this.Lbl_Genero.TabIndex = 4;
            this.Lbl_Genero.Text = "Género";
            // 
            // Lbl_Rating
            // 
            this.Lbl_Rating.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Rating.AutoSize = true;
            this.Lbl_Rating.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Rating.Location = new System.Drawing.Point(67, 160);
            this.Lbl_Rating.Name = "Lbl_Rating";
            this.Lbl_Rating.Size = new System.Drawing.Size(49, 15);
            this.Lbl_Rating.TabIndex = 5;
            this.Lbl_Rating.Text = "Rating";
            // 
            // Lbl_Actores
            // 
            this.Lbl_Actores.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Actores.AutoSize = true;
            this.Lbl_Actores.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Actores.Location = new System.Drawing.Point(62, 201);
            this.Lbl_Actores.Name = "Lbl_Actores";
            this.Lbl_Actores.Size = new System.Drawing.Size(54, 15);
            this.Lbl_Actores.TabIndex = 6;
            this.Lbl_Actores.Text = "Actores";
            // 
            // Lbl_Direccion
            // 
            this.Lbl_Direccion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Direccion.AutoSize = true;
            this.Lbl_Direccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Direccion.Location = new System.Drawing.Point(48, 238);
            this.Lbl_Direccion.Name = "Lbl_Direccion";
            this.Lbl_Direccion.Size = new System.Drawing.Size(68, 15);
            this.Lbl_Direccion.TabIndex = 7;
            this.Lbl_Direccion.Text = "Dirección";
            // 
            // Lbl_Sinopsis
            // 
            this.Lbl_Sinopsis.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Sinopsis.AutoSize = true;
            this.Lbl_Sinopsis.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Sinopsis.Location = new System.Drawing.Point(54, 277);
            this.Lbl_Sinopsis.Name = "Lbl_Sinopsis";
            this.Lbl_Sinopsis.Size = new System.Drawing.Size(62, 15);
            this.Lbl_Sinopsis.TabIndex = 8;
            this.Lbl_Sinopsis.Text = "Sinopsis";
            // 
            // R_Txt_Sinopsis
            // 
            this.R_Txt_Sinopsis.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.R_Txt_Sinopsis.Location = new System.Drawing.Point(51, 313);
            this.R_Txt_Sinopsis.Name = "R_Txt_Sinopsis";
            this.R_Txt_Sinopsis.Size = new System.Drawing.Size(613, 144);
            this.R_Txt_Sinopsis.TabIndex = 9;
            this.R_Txt_Sinopsis.Text = "";
            // 
            // Lbl_Anio_Produccion
            // 
            this.Lbl_Anio_Produccion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Anio_Produccion.AutoSize = true;
            this.Lbl_Anio_Produccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Anio_Produccion.Location = new System.Drawing.Point(381, 85);
            this.Lbl_Anio_Produccion.Name = "Lbl_Anio_Produccion";
            this.Lbl_Anio_Produccion.Size = new System.Drawing.Size(127, 15);
            this.Lbl_Anio_Produccion.TabIndex = 10;
            this.Lbl_Anio_Produccion.Text = "Año de Producción";
            // 
            // Lbl_Subgenero
            // 
            this.Lbl_Subgenero.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Subgenero.AutoSize = true;
            this.Lbl_Subgenero.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Subgenero.Location = new System.Drawing.Point(381, 125);
            this.Lbl_Subgenero.Name = "Lbl_Subgenero";
            this.Lbl_Subgenero.Size = new System.Drawing.Size(77, 15);
            this.Lbl_Subgenero.TabIndex = 11;
            this.Lbl_Subgenero.Text = "Subgénero";
            // 
            // Lbl_Duracion
            // 
            this.Lbl_Duracion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Lbl_Duracion.AutoSize = true;
            this.Lbl_Duracion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Lbl_Duracion.Location = new System.Drawing.Point(443, 160);
            this.Lbl_Duracion.Name = "Lbl_Duracion";
            this.Lbl_Duracion.Size = new System.Drawing.Size(65, 15);
            this.Lbl_Duracion.TabIndex = 12;
            this.Lbl_Duracion.Text = "Duración";
            // 
            // Txt_Actores
            // 
            this.Txt_Actores.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Txt_Actores.Location = new System.Drawing.Point(140, 201);
            this.Txt_Actores.Name = "Txt_Actores";
            this.Txt_Actores.Size = new System.Drawing.Size(524, 21);
            this.Txt_Actores.TabIndex = 13;
            // 
            // Txt_Direccion
            // 
            this.Txt_Direccion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Txt_Direccion.Location = new System.Drawing.Point(140, 238);
            this.Txt_Direccion.Name = "Txt_Direccion";
            this.Txt_Direccion.Size = new System.Drawing.Size(524, 21);
            this.Txt_Direccion.TabIndex = 14;
            // 
            // Txt_Duracion
            // 
            this.Txt_Duracion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Txt_Duracion.Location = new System.Drawing.Point(536, 160);
            this.Txt_Duracion.Name = "Txt_Duracion";
            this.Txt_Duracion.Size = new System.Drawing.Size(128, 21);
            this.Txt_Duracion.TabIndex = 15;
            // 
            // Txt_Anio_Produccion
            // 
            this.Txt_Anio_Produccion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Txt_Anio_Produccion.Location = new System.Drawing.Point(536, 85);
            this.Txt_Anio_Produccion.Name = "Txt_Anio_Produccion";
            this.Txt_Anio_Produccion.Size = new System.Drawing.Size(128, 21);
            this.Txt_Anio_Produccion.TabIndex = 16;
            // 
            // Cmb_Pais_Produccion
            // 
            this.Cmb_Pais_Produccion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Cmb_Pais_Produccion.FormattingEnabled = true;
            this.Cmb_Pais_Produccion.Location = new System.Drawing.Point(140, 85);
            this.Cmb_Pais_Produccion.Name = "Cmb_Pais_Produccion";
            this.Cmb_Pais_Produccion.Size = new System.Drawing.Size(216, 23);
            this.Cmb_Pais_Produccion.TabIndex = 17;
            // 
            // Cmb_Genero
            // 
            this.Cmb_Genero.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Cmb_Genero.FormattingEnabled = true;
            this.Cmb_Genero.Location = new System.Drawing.Point(140, 125);
            this.Cmb_Genero.Name = "Cmb_Genero";
            this.Cmb_Genero.Size = new System.Drawing.Size(216, 23);
            this.Cmb_Genero.TabIndex = 18;
            // 
            // Cmb_Rating
            // 
            this.Cmb_Rating.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Cmb_Rating.FormattingEnabled = true;
            this.Cmb_Rating.Location = new System.Drawing.Point(140, 160);
            this.Cmb_Rating.Name = "Cmb_Rating";
            this.Cmb_Rating.Size = new System.Drawing.Size(216, 23);
            this.Cmb_Rating.TabIndex = 19;
            // 
            // CmB_SubGenero
            // 
            this.CmB_SubGenero.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.CmB_SubGenero.FormattingEnabled = true;
            this.CmB_SubGenero.Location = new System.Drawing.Point(464, 122);
            this.CmB_SubGenero.Name = "CmB_SubGenero";
            this.CmB_SubGenero.Size = new System.Drawing.Size(200, 23);
            this.CmB_SubGenero.TabIndex = 20;
            // 
            // Btn_Nuevo
            // 
            this.Btn_Nuevo.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Btn_Nuevo.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Btn_Nuevo.Location = new System.Drawing.Point(409, 483);
            this.Btn_Nuevo.Name = "Btn_Nuevo";
            this.Btn_Nuevo.Size = new System.Drawing.Size(75, 23);
            this.Btn_Nuevo.TabIndex = 21;
            this.Btn_Nuevo.Text = "Nuevo";
            this.Btn_Nuevo.UseVisualStyleBackColor = true;
            // 
            // Btn_Guardar
            // 
            this.Btn_Guardar.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Btn_Guardar.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Btn_Guardar.Location = new System.Drawing.Point(499, 483);
            this.Btn_Guardar.Name = "Btn_Guardar";
            this.Btn_Guardar.Size = new System.Drawing.Size(75, 23);
            this.Btn_Guardar.TabIndex = 22;
            this.Btn_Guardar.Text = "Guardar";
            this.Btn_Guardar.UseVisualStyleBackColor = true;
            // 
            // Btn_Borrar
            // 
            this.Btn_Borrar.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Btn_Borrar.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Btn_Borrar.Location = new System.Drawing.Point(589, 483);
            this.Btn_Borrar.Name = "Btn_Borrar";
            this.Btn_Borrar.Size = new System.Drawing.Size(75, 23);
            this.Btn_Borrar.TabIndex = 23;
            this.Btn_Borrar.Text = "Borrar";
            this.Btn_Borrar.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(686, 706);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 24;
            this.button1.Text = "Salir";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // DGV_Eventos
            // 
            this.DGV_Eventos.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.DGV_Eventos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGV_Eventos.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.C_Canal,
            this.C_Fecha,
            this.C_Hora,
            this.C_Codificado});
            this.DGV_Eventos.Location = new System.Drawing.Point(18, 46);
            this.DGV_Eventos.Name = "DGV_Eventos";
            this.DGV_Eventos.Size = new System.Drawing.Size(669, 460);
            this.DGV_Eventos.TabIndex = 0;
            // 
            // C_Canal
            // 
            this.C_Canal.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.C_Canal.HeaderText = "Canal";
            this.C_Canal.Name = "C_Canal";
            this.C_Canal.Width = 86;
            // 
            // C_Fecha
            // 
            this.C_Fecha.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.C_Fecha.HeaderText = "Fecha";
            this.C_Fecha.Name = "C_Fecha";
            this.C_Fecha.Width = 89;
            // 
            // C_Hora
            // 
            this.C_Hora.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.C_Hora.HeaderText = "Hora";
            this.C_Hora.Name = "C_Hora";
            this.C_Hora.Width = 77;
            // 
            // C_Codificado
            // 
            this.C_Codificado.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.C_Codificado.HeaderText = "C_Codificado";
            this.C_Codificado.Name = "C_Codificado";
            this.C_Codificado.Width = 154;
            // 
            // Frm_Contenidos_Eventos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 733);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.TbC_Contenidos_Eventos);
            this.Controls.Add(this.GB_Titulo_Descripcion);
            this.Name = "Frm_Contenidos_Eventos";
            this.Text = "Contenidos y Eventos";
            this.GB_Titulo_Descripcion.ResumeLayout(false);
            this.GB_Titulo_Descripcion.PerformLayout();
            this.TbC_Contenidos_Eventos.ResumeLayout(false);
            this.TbP_Contenidos.ResumeLayout(false);
            this.TbP_Contenidos.PerformLayout();
            this.TbP_Eventos.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.DGV_Eventos)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox GB_Titulo_Descripcion;
        private System.Windows.Forms.Button Btn_Buscar;
        private System.Windows.Forms.ComboBox Cmb_Titulos;
        private System.Windows.Forms.Label Lbl_Titulo_Traducido;
        private System.Windows.Forms.TabControl TbC_Contenidos_Eventos;
        private System.Windows.Forms.TabPage TbP_Contenidos;
        private System.Windows.Forms.TabPage TbP_Eventos;
        private System.Windows.Forms.ComboBox CmB_SubGenero;
        private System.Windows.Forms.ComboBox Cmb_Rating;
        private System.Windows.Forms.ComboBox Cmb_Genero;
        private System.Windows.Forms.ComboBox Cmb_Pais_Produccion;
        private System.Windows.Forms.TextBox Txt_Anio_Produccion;
        private System.Windows.Forms.TextBox Txt_Duracion;
        private System.Windows.Forms.TextBox Txt_Direccion;
        private System.Windows.Forms.TextBox Txt_Actores;
        private System.Windows.Forms.Label Lbl_Duracion;
        private System.Windows.Forms.Label Lbl_Subgenero;
        private System.Windows.Forms.Label Lbl_Anio_Produccion;
        private System.Windows.Forms.RichTextBox R_Txt_Sinopsis;
        private System.Windows.Forms.Label Lbl_Sinopsis;
        private System.Windows.Forms.Label Lbl_Direccion;
        private System.Windows.Forms.Label Lbl_Actores;
        private System.Windows.Forms.Label Lbl_Rating;
        private System.Windows.Forms.Label Lbl_Genero;
        private System.Windows.Forms.Label Pais_Produccion;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label Lbl_Titulo_Original;
        private System.Windows.Forms.Button Btn_Borrar;
        private System.Windows.Forms.Button Btn_Guardar;
        private System.Windows.Forms.Button Btn_Nuevo;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.DataGridView DGV_Eventos;
        private System.Windows.Forms.DataGridViewTextBoxColumn C_Canal;
        private System.Windows.Forms.DataGridViewTextBoxColumn C_Fecha;
        private System.Windows.Forms.DataGridViewTextBoxColumn C_Hora;
        private System.Windows.Forms.DataGridViewTextBoxColumn C_Codificado;
    }
}