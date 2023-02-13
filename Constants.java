public class Constants {
        public static final Integer[][][] testMatrixes = {
                        {
                                        { 0, 0, 0 },
                                        { 1, 0, 1 }, // -
                                        { 0, 0, 0 }
                        },
                        {
                                        { 0, 1, 0 },
                                        { 0, 0, 0 }, // |
                                        { 0, 1, 0 }
                        },
                        {
                                        { 1, 0, 0 },
                                        { 0, 0, 0 }, // \
                                        { 0, 0, 1 }
                        },
                        {
                                        { 0, 0, 1 },
                                        { 0, 0, 0 }, // /
                                        { 1, 0, 0 }
                        }
        };
        public static final Integer[][][] testMatrixPositions = {
                        {
                                        { -1, 0 }, { 1, 0 }
                        },
                        {
                                        { 0, -1 }, { 0, 1 }
                        },
                        {
                                        { -1, 1 }, { 1, -1 }
                        },
                        {
                                        { -1, -1 }, { 1, 1 }
                        }

        };
}
